package kata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class UserImage {

    BufferedImage img;
    String fileName;
    String fileType;
    int imgHeight;
    int imgWidth;

    public UserImage(File file) {
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileName = file.getName();
        fileType = getFileType(file);
        imgHeight = img.getHeight();
        imgWidth = img.getWidth();
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHight) {
        this.imgHeight = imgHight;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public BufferedImage resizeImage() {
        BufferedImage resizedImage = new BufferedImage(imgHeight/2, imgWidth/2, img.getType());
        Graphics2D graphics2D = resizedImage.createGraphics();

        graphics2D.drawImage(img, 0,0,null);
        graphics2D.dispose();
        return resizedImage;
    }

    public void saveResizedImage() {
        try {
            File outputFile = new File(this.getFileName().substring(0, this.getFileName().lastIndexOf(".")) + "-resized");
            ImageIO.write(img, fileType, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileType(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImage userImage = (UserImage) o;
        return imgHeight == userImage.imgHeight &&
                imgWidth == userImage.imgWidth &&
                Objects.equals(img, userImage.img) &&
                Objects.equals(fileName, userImage.fileName) &&
                Objects.equals(fileType, userImage.fileType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(img, fileName, fileType, imgHeight, imgWidth);
    }

    @Override
    public String toString() {
        return "UserImage{" +
                "img=" + img +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", imgHeight=" + imgHeight +
                ", imgWidth=" + imgWidth +
                '}';
    }
}
