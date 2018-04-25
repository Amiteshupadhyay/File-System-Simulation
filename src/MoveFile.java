import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class MoveFile {
    public void moveFile(String source,String destination) {
        Path f = Paths.get(source);
        Path rF = Paths.get(destination);
        try {
            Files.move(f, rF, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}