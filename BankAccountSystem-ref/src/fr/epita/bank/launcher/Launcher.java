/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.bank.launcher;

import fr.epita.bank.business.InvestmentService;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.exceptions.BusinessException;

public class Launcher {

	public static void main(String[] args) {
		final Customer john = new Customer();

		john.setName("john");
		System.out.println("Hello " + john.getName() + "!");

		final SavingsAccount savings = new SavingsAccount();
		savings.setBalance(1500.0);
		savings.setCustomer(john);
		savings.setInterrestRate(0.0075);

		john.setName("");

		System.out.println("Have you lost your name, " + john.getName() + "?");
		System.out.println(john.getName()
				+ ", your savings account has the following characteristics "
				+ savings);

		final InvestmentAccount investment = new InvestmentAccount();
		investment.setBalance(150d);
		investment.setCustomer(john);

		final Stock gold = new Stock();
		gold.setName("gold");
		gold.setUnitPrice(15.0);

		final StockOrder stockOrder = new StockOrder();
		stockOrder.setAccount(investment);
		stockOrder.setQuantity(3);
		stockOrder.setStock(gold);
		stockOrder.setTicker(15d);

		try {
			InvestmentService.validateStockOrder(stockOrder);
		} catch (final BusinessException e) {
			// TODO display a message in the console
		}


	}
}

