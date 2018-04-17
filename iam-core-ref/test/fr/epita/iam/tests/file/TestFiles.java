/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.tests.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import fr.epita.iam.datamodel.Identity;

public class TestFiles {

	public static void main(String[] args) throws IOException {

		// basicFileTest();

		final Identity identity = new Identity();
		identity.setDisplayName("Thomas Broussard");
		identity.setEmail("tbr@tbr.com");
		identity.setUid("123");

		final File file = new File("C:/tmp/2018s1/identities.txt");
		final PrintWriter writer = initializePrintWriter(file);
		writeIdentity(identity, writer);
		writer.flush();
		writer.close();

	}

	/** 
	 * <h3>Description</h3>  
	 * <p>This methods allows to ...</p>
	 *
	 * <h3>Usage</h3>
	 * <p>It should be used as follows :
	 *   
	 * <pre><code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code></pre>
	 * </p>
	 *  
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 * ${tags}
	 */
	private static void writeIdentity(final Identity identity, final PrintWriter writer) {
		writer.println("---");
		writer.println(identity.getDisplayName());
		writer.println(identity.getEmail());
		writer.println(identity.getUid());
		writer.println("---");
	}

	/** 
	 * <h3>Description</h3>  
	 * <p>This methods allows to ...</p>
	 *
	 * <h3>Usage</h3>
	 * <p>It should be used as follows :
	 *   
	 * <pre><code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code></pre>
	 * </p>
	 *  
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 * ${tags}
	 */
	private static PrintWriter initializePrintWriter(final File file) throws IOException, FileNotFoundException {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		final FileOutputStream fos = new FileOutputStream(file, true);
		final PrintWriter writer = new PrintWriter(fos);
		return writer;
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
	private static void basicFileTest() throws IOException, FileNotFoundException {
		final File directory = new File("C:\\tmp\\2018s1");
		if (directory.exists()) {
			System.out.println("the directory exists");
		} else {
			System.out.println("the directory does not exist, cannot continue");
			return;
		}
		final File file = new File("C:\\tmp2\\2018s1\\identities.txt");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		final FileOutputStream fos = new FileOutputStream(file, true);
		final PrintWriter writer = new PrintWriter(fos);
		writer.println("hello!");
		writer.flush();
		fos.close();
		writer.close();
	}
}
