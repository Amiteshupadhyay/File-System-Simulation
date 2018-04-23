import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileSystems;

public class DeleteFile {
    DeleteFile(String[] args) {

        String x=Paths.get("").toAbsolutePath()+"\\"+args[0];

        Path path = FileSystems.getDefault().getPath(x);

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
