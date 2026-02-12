import java.nio.file.Path;
import java.io.IOException; //this is so if we are unable to load or find a file, we can catch that error

public interface FileReader {
    public String readFile(Path path) throws IOException;
}
