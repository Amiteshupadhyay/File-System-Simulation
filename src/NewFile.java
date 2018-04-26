import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewFile {
    public void newFile(String fileName) {
        String file=Paths.get(fileName).toString();
        Path newfile_2 = FileSystems.getDefault().getPath(file);
        try {
            Files.createFile(newfile_2);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
