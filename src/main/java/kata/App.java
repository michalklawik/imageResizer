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
//        BufferedImage img = null;
        File imageFile = new File("/home/caps/Projects/imageResizer/src/resources/background.jpg");

//        try {
//            img = ImageIO.read(imageFile);
//            img = resizeImage(img, img.getWidth(), img.getHeight());
//            saveResizedImage(img, imageFile.getName(), getFileType(imageFile));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        UserImage img = new UserImage(imageFile);
        img.resizeImage();
        img.saveResizedImage();
    }

//    private static BufferedImage resizeImage(BufferedImage orgImg, int imgW, int imgH) {
//        BufferedImage resizedImage = new BufferedImage(imgH/2, imgW/2, orgImg.getType());
//        Graphics2D graphics2D = resizedImage.createGraphics();
//
//        graphics2D.drawImage(orgImg, 0,0,null);
//        graphics2D.dispose();
//        return resizedImage;
//    }
//
//    private static void saveResizedImage(BufferedImage img, String fileName, String fileFormat) {
//        try {
//            File outputFile = new File(fileName);
//            ImageIO.write(img, fileFormat, outputFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String getFileType(File file) {
//        String fileName = file.getName();
//        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
//            return fileName.substring(fileName.lastIndexOf(".") + 1);
//        }
//        return "";
//    }
}
