package day24;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface = "day24.MtomInter")
@HandlerChain(file = "handler-chain.xml")
public class MtomService implements MtomInter {
	@Override
	public Image getImage(String name) throws Exception {
		File f = new File(name);
		return ImageIO.read(f);
	}

	@Override
	public void setImage(Image image, String name) {
		try {
			File fos = new File(name);
			BufferedImage bImage = (BufferedImage) image;
			ImageIO.write(bImage, "jpg", fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

@WebService
interface MtomInter {
	public Image getImage(String name) throws Exception;

	public void setImage(Image image, String name);
}