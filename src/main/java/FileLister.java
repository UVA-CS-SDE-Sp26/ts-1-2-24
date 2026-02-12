import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLister {
    public static List<Path> outputFiles(Path filePath) {
        try (Stream<Path> stream = Files.list(filePath)) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            return List.of();
        }
    }
}
