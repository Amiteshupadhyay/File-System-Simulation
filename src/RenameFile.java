import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RenameFile {
    public void renameFile(String directory,String oldName,String newName) {
        Path sourcePath = Paths.get(directory+"\\"+oldName);
        Path destinationPath = Paths.get(directory+"\\"+newName);
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
