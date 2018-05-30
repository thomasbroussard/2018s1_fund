/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.launcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.IdentityDAO;
import fr.epita.iam.services.IdentityDAOFactory;
import fr.epita.iam.ui.ConsoleOperations;

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
public class Launcher {

	/**
	 *
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
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// initialize resources
		IdentityDAO dao = null;
		try {
			dao = IdentityDAOFactory.getDAO();
		} catch (final Exception e) {
			// TODO log
			// cannot continue
			return;
		}
		final ConsoleOperations console = new ConsoleOperations();
		// Welcome
		// Authentication

		// Menu

		// Create
		final Identity identity = console.readIdentityFromConsole();
		dao.create(identity);

		// Search?
		final Identity criteria = console.readCriteriaFromConsole();
		final List<Identity> resultList = dao.search(criteria);
		console.displayIdentitiesInConsole(resultList);

		// Update

		// Delete
		console.releaseResources();

	}

}
