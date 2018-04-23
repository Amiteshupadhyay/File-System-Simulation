import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RenameFile {
    RenameFile(String[] args) {
        Path sourcePath = Paths.get("./"+args[0]);
        Path destinationPath = Paths.get("./"+args[1]);
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File was successfully renamed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to rename file");
        }
    }
}
