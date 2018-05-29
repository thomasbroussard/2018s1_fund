/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		final String url = "jdbc:derby://localhost:1527/testInstance;create=true";
		Connection connection = null;

		// When I connect
		connection = DriverManager.getConnection(url, "test", "test");
		return connection;

	}

	public void create(Identity identity) {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO IDENTITIES (IDENTITY_DISPLAYNAME, IDENTITY_EMAIL, IDENTITY_UID) VALUES (?, ?, ?)");
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
		return list;
	}

}
