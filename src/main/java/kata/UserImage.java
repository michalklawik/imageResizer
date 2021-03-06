package kata;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class UserImage {

    private BufferedImage img;
    private String fileName;
    private String fileType;
    private int imgHeight;
    private int imgWidth;

    UserImage(File file) {
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileType = getFileType(file);
        fileName = file.getName().replace("." + fileType, "");
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

    static File getImage() {
        final JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter fileFilter = new FileNameExtensionFilter("Image", "jpg", "png", "jpeg");
        chooser.addChoosableFileFilter(fileFilter);
        chooser.showOpenDialog(null);
        return chooser.getSelectedFile();
    }

    BufferedImage resizeImage() {
        Image temp = img.getScaledInstance(imgWidth/2, imgHeight/2, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(imgWidth/2, imgHeight/2, img.getType());
        Graphics2D graphics2D = resizedImage.createGraphics();

        graphics2D.drawImage(temp, 0,0,null);
        graphics2D.dispose();
        return resizedImage;
    }

    void saveResizedImage() {
        final JFileChooser saver = new JFileChooser();
        saver.setSelectedFile(new File(fileName + "_resized." + fileType));
        saver.showSaveDialog(null);
        try {
            ImageIO.write(resizeImage(), fileType, saver.getSelectedFile());
            JOptionPane.showMessageDialog(null, "Resized image saved :)", "Save image", JOptionPane.INFORMATION_MESSAGE);
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
