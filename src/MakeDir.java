import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeDir {
    public void makeDir(String args) {
        String newDirec=Paths.get(args).toString();
        Path newdir_1 = FileSystems.getDefault().getPath(newDirec);
        try {
            Files.createDirectory(newdir_1);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
