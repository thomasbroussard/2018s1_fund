/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class IdentityJDBCDAO {

	private static Connection getConnection() throws SQLException {
		// Given this context
		final String url = ConfigurationService.getProperty("db.url");
		Connection connection = null;

		// When I connect
		connection = DriverManager.getConnection(url, ConfigurationService.getProperty("db.user"), ConfigurationService.getProperty("db.pwd"););
		return connection;

	}

	public void create(Identity identity) {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement pstmt = connection
					.prepareStatement(ConfigurationService.getProperty("identity.search"));
			pstmt.setString(1, identity.getDisplayName());
			pstmt.setString(2, identity.getEmail());
			pstmt.setString(3, identity.getUid());
			pstmt.execute();
			pstmt.close();
			connection.close();
		} catch (final SQLException e) {
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e1) {
					// TODO handle that
				}
			}
		}
	}

	public void delete(Identity identity) {

	}

	public void update(Identity identity) {

	}

	public Identity getById(int id) {
		final Identity identity = new Identity();

		return identity;
	}

	public List<Identity> search(Identity criteria) {
		final List<Identity> list = new ArrayList<>();

		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement pstmt = connection
					.prepareStatement("select IDENTITY_DISPLAYNAME, IDENTITY_EMAIL, IDENTITY_UID from IDENTITIES"
							+ " where IDENTITY_DISPLAYNAME like ? or IDENTITY_EMAIL like ?");
			pstmt.setString(1, "%" + criteria.getDisplayName() + "%");
			pstmt.setString(2, "%" + criteria.getEmail() + "%");
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				final String displayName = rs.getString("IDENTITY_DISPLAYNAME");
				final String email = rs.getString("IDENTITY_EMAIL");
				final String uid = rs.getString("IDENTITY_UID");
				final Identity identity = new Identity(displayName, uid, email);
				list.add(identity);

			}

			pstmt.close();
			connection.close();
		} catch (final SQLException e) {
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e2) {
					// TODO handle
				}
			}
		}
		return list;
	}

}
