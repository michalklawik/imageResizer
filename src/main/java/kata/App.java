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

        System.out.println(String.valueOf(img.getHeight()));
        System.out.println(resizeImage(img, img.getWidth(), img.getHeight()).getHeight());
    }

    private static BufferedImage resizeImage(BufferedImage orgImg, int imgW, int imgH) {
        BufferedImage resizedImage = new BufferedImage(imgH/2, imgW/2, orgImg.getType());
        Graphics2D graphics2D = resizedImage.createGraphics();

        graphics2D.drawImage(orgImg, 0,0,null);
        graphics2D.dispose();
        return resizedImage;
    }
}
