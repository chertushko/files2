import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
