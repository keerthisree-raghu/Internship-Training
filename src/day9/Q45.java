package day9;

public class Q45 {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		account.setDepositorName("John Doe");
		account.setAccountNumber("5001021");
		account.setAccountType("Savings");
		account.setBalanceAmount(20000);
		account.checkBalance();
		account.deposit(5000);
		account.checkBalance();
	}
}

class BankAccount {
	static String depositorName, accountType, accountNumber;
	static double balanceAmount;
	
	public void setDepositorName(String depositorName) {
		this.depositorName = depositorName;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalanceAmount(double balanceAmount) {
		if(balanceAmount >= 0) {
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