package Helpers;

import java.io.File;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<String> getListOfFileNames_InFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<>();
        for (File file : listOfFiles) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }

    public static void emptyTheFolder(String folderPath) {
        ArrayList<String> files_Folders_InFolder = getListOfFileNames_InFolder(folderPath);
        for (String eachFileInFolder : files_Folders_InFolder) {
            deleteFile(folderPath + "\\" + eachFileInFolder);
        }

    }

    public static void deleteFile(String path) {
        File fileToDelete = new File(path);
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println(path.substring(path.lastIndexOf("\\") + 1) + " Deleted");
            }
            else {
                System.out.println(path.substring(path.lastIndexOf("\\") + 1) + " not deleted");
            }
        }
    }
}
