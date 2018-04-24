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
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;

public class FileIdentityDAO {

	private final PrintWriter writer;
	private final Scanner scanner;

	public FileIdentityDAO() throws FileNotFoundException, IOException {
		final File file = new File("C:/tmp/2018s1/identities.txt");
		writer = initializePrintWriter(file);
		scanner = initializeScanner(file);
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
		final ArrayList<Identity> list = new ArrayList<>();
		while (scanner.hasNext()) {
			scanner.nextLine();
			final String displayName = scanner.nextLine();
			final String email = scanner.nextLine();
			final String uid = scanner.nextLine();
			scanner.nextLine();
			list.add(new Identity(displayName, email, uid));

		}

		return list;
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

	private static Scanner initializeScanner(final File file) throws IOException, FileNotFoundException {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		return new Scanner(file);
	}

	public void releaseResources() {
		writer.close();
	}
}
