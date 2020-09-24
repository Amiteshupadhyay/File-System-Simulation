import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {
    public static void copyFile(String source,String destination) {
        
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination);
        try {
            Files.copy(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
