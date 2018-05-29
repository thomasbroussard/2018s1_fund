/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

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
public class ConfigurationService {

	private static Properties properties;

	static {
		init();
	}

	private static void init() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File(System.getProperty("conf.file.path"))));
		} catch (final Exception e) {
			// TODO treat exception
		}


	}

	public static Integer getIntProperty(String key) {
		final String valueAsString = getProperty(key);
		return Integer.valueOf(valueAsString);
	}
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
