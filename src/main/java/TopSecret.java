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
        System.out.println(new CLI(new WorkingDirectoryFileLister(), new FileHandler()).getOutput(args));
    }
}