import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;

public class DeleteFile {
    public void deleteFile(String args) {

        Path path = FileSystems.getDefault().getPath(args);

        try {
            Files.delete(path);
        } catch (DirectoryNotEmptyException e) {
            System.err.println("Directory is not empty "+e.getMessage());
        }
        catch (NoSuchFileException e) {
            System.err.println("Directory does not exists "+e.getMessage());
        }
        catch (IOException e){
            System.err.println("Fatal error");
        }
    }
}
