/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.tests.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class XMLTests {


	public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		final File file = new File("test/identities.xml");
		if (!file.exists()) {
			return;
		}
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		final DocumentBuilder db = dbf.newDocumentBuilder();
		final Document document = db.parse(new FileInputStream(file));

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

		}



	}

}
