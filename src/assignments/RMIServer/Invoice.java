package assignments.RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Invoice extends Remote{
	public void startInvoiceApp(int choice, int invoiceNumber)throws RemoteException;
}
