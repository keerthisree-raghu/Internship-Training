package springtransactions;

public interface MoneyTransferBean {
	public void credit(int accountId, int amount) throws Exception;

	public void debit(int accountId, int amount) throws Exception;
}
