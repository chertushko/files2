import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Programm {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File dirSavegames = new File("C://Users//User//IdeaProjects//Games//savegames");

        createdDir(new File("C://Users//User//IdeaProjects//Games//src"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//res"), log);
        createdDir(dirSavegames, log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//temp"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//src//main"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//src//test"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//res//drawables"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//res//vectors"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//res//icons"), log);
        createdFile(new File("C://Users//User//IdeaProjects//Games//src//main//Main.java"), log);
        createdFile(new File("C://Users//User//IdeaProjects//Games//src//main//Utils.java"), log);
        createdFile(new File("C://Users//User//IdeaProjects//Games//temp//temp.txt"), log);

        System.out.println(log);
        try (FileWriter writer = new FileWriter("C://Users//User//IdeaProjects//Games//temp//temp.txt")) {
            writer.write(String.valueOf(log));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        GameProgress progress1 = new GameProgress(10, 2, 5, 55.25);
        GameProgress progress2 = new GameProgress(4, 15, 8, 107.68);
        GameProgress progress3 = new GameProgress(1, 8, 13, 498.66);
        String path1 = dirSavegames + "//save1.dat";
        String path2 = dirSavegames + "//save2.dat";
        String path3 = dirSavegames + "//save3.dat";

        String zip = dirSavegames + "//zip.zip";

        saveGame(path1, progress1);
        saveGame(path2, progress2);
        saveGame(path3, progress3);

        File[] fileList = dirSavegames.listFiles();

        for (File file : fileList) {
            if (zipFiles(zip, fileList)) {
                file.delete();
                System.out.println(file.getName() + " архивирован");
            }
        }
    }

    static StringBuilder createdDir(File newFile, StringBuilder sb) {
        boolean created = newFile.mkdir();
        if (created) {
            sb.append("Folder " + newFile.getName() + " has been created\n");
        }
        return sb;
    }

    static StringBuilder createdFile(File newFile, StringBuilder sb) {
        try {
            boolean created = newFile.createNewFile();
            if (created) {
                sb.append("Folder " + newFile.getName() + " has been created\n");
            }
        } catch (IOException ex) {
            sb.append(ex.getMessage());
        }
        return sb;
    }

    static boolean saveGame(String path, GameProgress progress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    static boolean zipFiles(String zip, File[] files) {
        for (File file : files) {
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip));
                 FileInputStream fis = new FileInputStream(file)) {
                ZipEntry entry = new ZipEntry(file.getName());
                zos.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
}
