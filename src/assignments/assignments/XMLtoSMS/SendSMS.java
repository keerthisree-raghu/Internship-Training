package assignments.XMLtoSMS;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendSMS {
	private SimpleDateFormat dateFormat;

	public void SendSMSMessage(String recipient) {
		try {
			String message = "Invoice has been generated on " + dateFormat.format(new Date() + ".");
			String username = "YOUR_USERNAME";
			String password = "YOUR_PASSWORD";
			String sender = "YOUR_NUMBER";

			String requestUrl = "http://127.0.0.1:9501/api?action=sendmessage&" + "username="
					+ URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8")
					+ "&recipient=" + URLEncoder.encode(recipient, "UTF-8") + "&messagetype=SMS:TEXT" + "&messagedata="
					+ URLEncoder.encode(message, "UTF-8") + "&originator=" + URLEncoder.encode(sender, "UTF-8")
					+ "&serviceprovider=GSMModem1" + "&responseformat=html";
			
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();

			System.out.println(connection.getResponseMessage());

			connection.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
