/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

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
	}
}

