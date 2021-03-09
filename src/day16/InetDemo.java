package day16;

import java.net.InetAddress;

public class InetDemo {
	public static void main(String[] args) throws Exception {
		InetAddress inetAddr = InetAddress.getByName("www.irctc.co.in");
		System.out.println(inetAddr.getHostAddress());
		InetAddress inetArray[] = InetAddress.getAllByName("www.irctc.co.in");
		for(InetAddress address : inetArray) {
			System.out.println(address.getHostAddress());
		}
		InetAddress inetName = InetAddress.getByAddress(new byte[] {103, 10, 10, 10});
		System.out.println(inetName.getHostName());
	}
}
