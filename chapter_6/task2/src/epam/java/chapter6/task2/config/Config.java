package epam.java.chapter6.task2.config;

public class Config {
    private static String rootPath = "";

    public static void setRootPath(String rootPath){
        Config.rootPath = rootPath;
    }

    public static String getRootPath(){
        return Config.rootPath;
    }

    private static String getFilePath(String fileName) {
        if (Config.getRootPath() == null) {
            return "resource/" + fileName;
        } else {
            return Config.getRootPath() + fileName;
        }
    }
}
