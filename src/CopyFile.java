import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {
    public static String copyFile(String[] args) {
        Path sourcePath = Paths.get("./"+args[0]);
        Path destinationPath = Paths.get("./"+args[1]);
        try {
            Files.copy(sourcePath, destinationPath);
            return "File was successfully copied";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to copy file";
        }
    }
}
