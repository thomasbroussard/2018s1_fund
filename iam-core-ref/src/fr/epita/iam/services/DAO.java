/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services;

import java.io.Serializable;
import java.util.List;

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
public interface DAO<T> {

	public void create(T entity);

	public void delete(T entity);

	public void update(T entity);

	public Identity getById(Serializable id);

	public List<Identity> search(T criteria);

}
