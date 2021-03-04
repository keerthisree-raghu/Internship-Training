package CollectionsTest;

import java.util.HashMap;
import java.util.Map;

/*
 * OPTION B, OPTION G 
 */

public class Q29 {
//	private Map<String, Integer> accountTotals = new HashMap<String, Integer>();
	private Map accountTotals = new HashMap();
	private int retirementFund;

	public int getBalance(String accountName) {
		Integer total = (Integer)accountTotals.get(accountName);
		if(total == null) {
			total = Integer.valueOf(0);
		}
		return total.intValue();
	}

	public void setBalance(String accountName, int amount) {
		accountTotals.put(accountName, Integer.valueOf(amount));
//		accountTotals.put(accountName, amount);
	}
}