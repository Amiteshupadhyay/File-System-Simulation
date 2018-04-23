import java.nio.file.Paths;

public class GetPath {
    String getPath() {
        try {
            return Paths.get("").toAbsolutePath().toString();
        } catch (Exception e) {
            System.err.println(e);
        }
        return "";
    }
}
