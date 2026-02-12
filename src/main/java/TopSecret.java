/**
 * Commmand Line Utility
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.OptionalInt;

public class TopSecret {
    public static void main(String[] args) {
        Path path = Paths.get("src", "data");
        OptionalInt fileNum = ArgParser.parseArgs(args);
        if (!fileNum.isPresent()) {
            List<Path> pathList = outputFiles(path);
            for (int i = 0; i < pathList.size(); i++) {
                System.out.printf("%02d %s%n", i + 1, pathList.get(i).getFileName());
            }
        }
    }


    public static List<Path> outputFiles(Path filePath) {
        try (Stream<Path> stream = Files.list(filePath)) {
            List<Path> pathList = stream.collect(Collectors.toList());
            return pathList;
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            return List.of();
        }
    }

}