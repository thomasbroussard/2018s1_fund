/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services;

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
public enum ConfKey {
	/**
	 * this is the key to choose the backend mode
	 */
	BACKEND_MODE("backend.mode"),
	/**
	 * this is the key to choose the fall back backend mode
	 */

	FALLBACK_BACKEND_MODE("backend.mode"),

	;

	private String key;

	/**
	 *
	 */
	private ConfKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
