package day9;

public class Q46 {
	public static void main(String[] args) {
		BankAccountConstructor account = new BankAccountConstructor("Jane Doe", "Savings", "50020132", 30000);
		account.checkBalance();
		account.deposit(5000);
		account.checkBalance();
	}
}

class BankAccountConstructor {
	static String depositorName, accountNumber, accountType;
	static double balanceAmount;
	
	public BankAccountConstructor(String depositorName, String accountType, String accountNumber, int balanceAmount) {
		this.depositorName = depositorName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		if(balanceAmount > 0) {
			this.balanceAmount = balanceAmount;
		}
		else {
			System.out.println("Invalid amount");
		}
	}

	public static void deposit(int amount) {
		if(amount > 0) {
			balanceAmount += amount;
			System.out.println(amount + " deposited.");
		}
		else {
			System.out.println("Invalid amount");
		}
	}
	
	public static void checkBalance() {
		System.out.println("Account Owner: " + depositorName);
		System.out.println("Balance: " + balanceAmount);
	}
}