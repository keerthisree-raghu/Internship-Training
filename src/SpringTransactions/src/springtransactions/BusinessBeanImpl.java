package springtransactions;

public class BusinessBeanImpl implements BusinessBean {
	private MoneyTransferBean moneyTransfer;
	
	public MoneyTransferBean getMoneyTransfer() {
		return moneyTransfer;
	}

	public void setMoneyTransfer(MoneyTransferBean moneyTransfer) {
		this.moneyTransfer = moneyTransfer;
	}

	@Override
	public void doTransaction(int creditAccountId, int debitAccountId, int amount) throws Exception {
		moneyTransfer.credit(creditAccountId, amount);
		moneyTransfer.debit(debitAccountId, amount);
	}
}
