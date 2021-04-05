package day24;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ReadClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:3000/ws/hello?wsdl");
		QName qName = new QName("http://day24/", "MtomServiceService");
		Service service = Service.create(url, qName);
		MtomInter mtom = service.getPort(MtomInter.class);
		Image image = mtom.getImage("earrings.jpg");
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		JLabel label = new JLabel(new ImageIcon(image));
		frame.add(label);
		frame.setVisible(true);
	}
}
