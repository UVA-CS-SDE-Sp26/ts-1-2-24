import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingDirectoryFileLister implements FileLister {
    private Path filePath;
    public WorkingDirectoryFileLister(){
        this.filePath = Path.of("data");
    }
    public WorkingDirectoryFileLister(String path){
        this.filePath = Path.of(path);
    }

    public List<Path> getFileList() {
        try (Stream<Path> stream = Files.list(filePath)) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            return List.of();
        }
    }
}
