package day17;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle {
	Object obj[][] = {
			{"hello", "vanakkam"}
	};
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
