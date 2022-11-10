import java.util.Scanner;

public class IncomeTaxCalculation {

	public static void main(String[] args) {

		IncomeTaxCalculation ob = new IncomeTaxCalculation();

		// created Sacanner object to take the input
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the county between India and USA: ");
		String country = sc.nextLine();

		double tax = 0;
		if (Boolean.TRUE.equals(country.equalsIgnoreCase("India"))) {
			
			System.out.print("Enter your salary: ");
			double income = sc.nextDouble();
			tax = calculateTaxForIndia(income);
			displayResult(income, tax);
		
		} else if (Boolean.TRUE.equals(country.equalsIgnoreCase("USA"))) {
			System.out.print("Enter your salary: ");
			double income = sc.nextDouble();
			tax = calculateTaxForUsa(income);
			displayResult(income, tax);
		} else {
			System.out.println(country + " Tax calculation does not exist");
		}

	}

	static double calculateTaxForIndia(double income) {
		double tax = 0;
		double duductedIncome = 0;

		if (income <= 250000) {
			tax = 0;
		} else if (income >= 250001 && income <= 500000) {
			duductedIncome = income - 250000;
			tax = 0.05 * appIncome;
		} else if (income >= 500001 && income <= 1000000) {
			duductedIncome = income - 500000;
			tax = 12500 + (0.20 * appIncome);
		} else { // income > 1000000
			duductedIncome = income - 1000000;
			tax = 112500 + (0.30 * appIncome);
		}

		return tax;
	}

	static double calculateTaxForUsa(double userIncome) {

		double federalExemption = 11327.0;
		double provincialExemption = 9863.0;
		double federalTax = (userIncome - federalExemption) * 0.15;
		double provincialTax = (userIncome - provincialExemption) * 0.0505;
		double totalTax = federalTax + provincialTax;

		return totalTax;
	}

	static void displayResult(double income, double tax) {
		System.out.println("Total Income " + income + " and tax." + tax);
	}

}
