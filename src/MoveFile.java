import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class MoveFile {
    MoveFile(String[] args) {
        Path f = Paths.get("./"+args[0]);
        Path rF = Paths.get("./"+args[1]);
        try {
            Files.move(f, rF, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File was successfully moved");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to move file");
        }
    }
}
