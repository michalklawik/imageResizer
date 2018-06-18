package kata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("/home/caps/Projects/imageResizer/src/resources/background.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.printf(String.valueOf(img.getHeight()));
    }

    private static BufferedImage resizeImage(BufferedImage orgImg, int imgW, int imgH) {
        BufferedImage resizedImage = new BufferedImage(imgH, imgW, orgImg.getType());
        Graphics2D graphics2D = resizedImage.createGraphics();

//        graphics2D.d
        return null;
    }
}
