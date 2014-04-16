package imageprocessing;

import main.PicsiSWT;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class Inverter implements IImageProcessor {

	@Override
	public boolean isEnabled(int imageType) {
		return imageType != PicsiSWT.IMAGE_TYPE_INDEXED;
	}

	@Override
	public Image run(Image input, int imageType) {
		ImageData inData = input.getImageData();
		byte[] data = inData.data;

		for (int i = 0; i < data.length; i++) {
			data[i] = (byte) ~data[i];
		}
		return new Image(input.getDevice(), inData);
	}

}
