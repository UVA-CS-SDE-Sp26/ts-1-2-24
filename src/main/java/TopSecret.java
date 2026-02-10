/**
 * Commmand Line Utility
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TopSecret {
    public static void main(String[] args){

    }

}

public static void outputFiles(Path filePath){
    try (Stream<Path> stream = Files.list(filePath)) {
        List<Path> pathList = stream.collect(Collectors.toList());
        for(int i = 0; i < pathList.size(); i++){
            System.out.printf("%02d %s%n", i + 1, pathList.get(i).getFileName());
        }
    } catch (IOException e) {
        System.err.println("An I/O error occurred: " + e.getMessage());
    }
}

