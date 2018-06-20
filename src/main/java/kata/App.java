package kata;

public class App
{
    public static void main( String[] args )
    {
        UserImage img = new UserImage(UserImage.getImage());
        img.resizeImage();
        img.saveResizedImage();
    }
}
