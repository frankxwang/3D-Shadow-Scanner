import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FFmpegFrameGrabber g = new FFmpegFrameGrabber("small.mp4");
		g.start();
		BufferedImage img = new BufferedImage(g.getImageWidth(), g.getImageHeight(), BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0 ; i < g.getLengthInFrames() ; i++) {
			Java2DFrameConverter.copy(g.grabImage(), img);
		    ImageIO.write(img, "png", new File("video-frame-" + i + ".png"));
		}

		g.stop();
	}

}
