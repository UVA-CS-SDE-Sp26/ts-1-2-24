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
        int fileNum = 1;
        for (int i = 0; i < stream.length; i++){
            String output = String.format("0%d "
        }
    } catch (IOException e) {
        System.err.println("An I/O error occurred: " + e.getMessage());
    }
}

public static void printContents(){

}