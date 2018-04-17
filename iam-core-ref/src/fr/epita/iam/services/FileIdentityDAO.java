/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;

public class FileIdentityDAO {

	PrintWriter writer;

	public FileIdentityDAO() throws FileNotFoundException, IOException {
		writer = initializePrintWriter(new File("C:/tmp/2018s1/identities.txt"));
	}

	public void create(Identity identity) {
		writer.println("---");
		writer.println(identity.getDisplayName());
		writer.println(identity.getEmail());
		writer.println(identity.getUid());
		writer.println("---");
		writer.flush();
	}

	public List<Identity> search(Identity criteria) {

		return new ArrayList<>();
	}

	public void update(Identity identity) {

	}

	public void delete(Identity identity) {

	}

	private static PrintWriter initializePrintWriter(final File file) throws IOException, FileNotFoundException {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		final FileOutputStream fos = new FileOutputStream(file, true);
		final PrintWriter writer = new PrintWriter(fos);
		return writer;
	}

	public void releaseResources() {
		writer.close();
	}
}
