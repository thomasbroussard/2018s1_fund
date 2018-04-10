/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.bank.business;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.StockOrder;

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
public class InvestmentService {

	public static void validateStockOrder(StockOrder order) {
		final InvestmentAccount account = order.getAccount();
		final Double balance = account.getBalance();
		if (balance == null || balance == 0) {
			// error case
			return;
		}
		// perform operation : final balance = initialBalance - (stockUnitPrice * stockOrderQuantity) - ticker
		final Double finalBalance = balance - order.getStock().getUnitPrice() * order.getQuantity() - order.getTicker();

		account.setBalance(finalBalance);

	}

}
