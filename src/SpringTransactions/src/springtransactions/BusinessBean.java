package springtransactions;

public interface BusinessBean {
	public void doTransaction(int creditAccountId, int debitAccountId, int amount) throws Exception;
}
