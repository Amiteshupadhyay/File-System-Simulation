import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class NewFile {
    NewFile(String args) {
        String file=Paths.get("").toAbsolutePath()+"\\"+args;
        Path newfile_2 = FileSystems.getDefault().getPath(file);
        try {
            Files.createFile(newfile_2);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
