import animatedgifencoder.AnimatedGIFEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class TestAnimatedGifEncoder {

    public static final void main(String[] args) throws Exception{

        AnimatedGIFEncoder encoder = new AnimatedGIFEncoder();
        encoder.start("testout.gif");
        encoder.setDelay(1000);
        encoder.setTransparent(0xffffff);

        String[] inputs = new String[]{
                "1.png",
                "2.png",
                "3.png"
        };
        for( String input : inputs ) {
            InputStream inputStream = TestAnimatedGifEncoder.class.getResourceAsStream(input);
            try {
                BufferedImage image = ImageIO.read(inputStream);
                int[] pixels = new int[image.getWidth() * image.getHeight()];
                image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
                encoder.addFrame(pixels, image.getWidth(), image.getHeight());
            } finally {
                inputStream.close();
            }
        }
        encoder.finish();
    }

}
