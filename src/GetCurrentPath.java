import java.nio.file.Paths;

public class GetCurrentPath {
    String getPath() {
        try {
            return Paths.get("").toAbsolutePath().toString();
        } catch (Exception e) {
            System.err.println(e);
        }
        return "";
    }
}
