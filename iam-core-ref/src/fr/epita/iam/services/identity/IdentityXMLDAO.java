/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.services.identity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.EntityCreationException;
import fr.epita.iam.exceptions.EntityDeletionException;
import fr.epita.iam.exceptions.EntityReadException;
import fr.epita.iam.exceptions.EntitySearchException;
import fr.epita.iam.exceptions.EntityUpdateException;

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
public class IdentityXMLDAO implements IdentityDAO {

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#create(java.lang.Object)
	 */
	@Override
	public void create(Identity entity) throws EntityCreationException {

	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Identity entity) throws EntityDeletionException {

	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#update(java.lang.Object)
	 */
	@Override
	public void update(Identity entity) throws EntityUpdateException {

	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#getById(java.io.Serializable)
	 */
	@Override
	public Identity getById(Serializable id) throws EntityReadException {
		return new Identity();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#search(java.lang.Object)
	 */
	@Override
	public List<Identity> search(Identity criteria) throws EntitySearchException {
		final List<Identity> results = new ArrayList<>();
		final File file = new File("test/identities.xml");
		if (!file.exists()) {
			return results;
		}
		Document document = null;

		try {
			document = getDocument(file);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// FIXME Use a logger to trace the following error
			// LOGGER.error("An error occured", ${exception_var})
			// ignore this at this moment, but it is to be converted to a "DaoInitializationException"
		}

		final NodeList identityNodes = document.getElementsByTagName("identity");

		for (int i = 0; i < identityNodes.getLength(); i++) {
			final Identity identity = new Identity();
			final Element item = (Element) identityNodes.item(i);
			final String displayName = item.getElementsByTagName("displayName").item(0).getTextContent();
			final String email = item.getElementsByTagName("email").item(0).getTextContent();
			final String uid = item.getElementsByTagName("uid").item(0).getTextContent();
			identity.setDisplayName(displayName);
			identity.setEmail(email);
			identity.setUid(uid);
			results.add(identity);
		}

		return results;
	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to ...
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 *
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code>
	 * </pre>
	 * </p>
	 *
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 */
	private Document getDocument(final File file) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException {
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		final DocumentBuilder db = dbf.newDocumentBuilder();
		final Document document = db.parse(new FileInputStream(file));
		return document;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.identity.IdentityDAO#healthCheck()
	 */
	@Override
	public boolean healthCheck() {
		return true;
	}

}
