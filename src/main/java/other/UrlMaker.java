package other;

public class UrlMaker {
    public static String make(String dir, String extension) {
         return System.getProperty("user.dir") + "/"+ dir +"/" + Watchmaker.getCurrentTime("dd.MM.yyyy HH:mm:ss") + "." + extension;
    }
}
