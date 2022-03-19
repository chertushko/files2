import java.io.*;

public class Programm {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        createdDir(new File("C://Users//User//IdeaProjects//Games//src"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//res"), log);
        createdDir(new File("C://Users//User//IdeaProjects//Games//savegames"), log);
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

//        String path = "C://Users//User//IdeaProjects//Games//savegames";
        saveGame("C://Users//User//IdeaProjects//Games//savegames//save1.dat", progress1);
        saveGame("C://Users//User//IdeaProjects//Games//savegames//save2.dat", progress2);
        saveGame("C://Users//User//IdeaProjects//Games//savegames//save3.dat", progress3);
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
        System.out.println(progress);
        return true;
    }
}
