package day24;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class MtomClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:3000/ws/hello?wsdl");
		QName qName = new QName("http://day24/", "MtomServiceService");
		Service service = Service.create(url, qName);
		MtomInter mtom = service.getPort(MtomInter.class);
		BindingProvider bp = (BindingProvider) mtom;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		Image image = ImageIO.read(new URL("https://tribecdn.tribeamrapali.com/Catalog/Product/00/10/ID10503_9757_IMG_1_1645bff9ad744dd2bf5f7b04eb6d87fb.jpg"));
		mtom.setImage(image, "earrings.jpg");
	}
}
