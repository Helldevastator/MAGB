package imageprocessing;

import main.PicsiSWT;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;

public class Inverter implements IImageProcessor {

	@Override
	public boolean isEnabled(int imageType) {
		// TODO Auto-generated method stub
		return imageType != PicsiSWT.IMAGE_TYPE_INDEXED;
	}

	@Override
	public Image run(Image input, int imageType) {
		ImageData inData = input.getImageData();

		byte[] data = inData.data;

		for (int v = 0; v < inData.height; v++) {
			for (int u = 0; u < inData.width; u++) {
				int pixel = inData.getPixel(u, v);
				RGB rgb = inData.palette.getRGB(pixel);
				rgb.blue = 0;
				rgb.red = 0;
				pixel = inData.palette.getPixel(rgb);
				inData.setPixel(u, v, pixel);
			}
		}

		return new Image(input.getDevice(), inData);
	}

}
