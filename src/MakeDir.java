import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeDir {
    MakeDir(String[] args) {
        String newDirec=Paths.get("").toAbsolutePath()+"\\"+args[0];
        Path newdir_1 = FileSystems.getDefault().getPath(newDirec);
        try {
            Files.createDirectory(newdir_1);
            System.out.println(args[0]+" created successfully.");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
