import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void readFile_whenFileExists() throws IOException {
        FileHandler fileHandler = new FileHandler();
        String filePath = "data/carnivore.txt";
        //What kinds of situations might we confront:
                //We read a class file, we display the code
                //We read a txt file, we display the text
                //We read... nothing -> should throw an error

        Path realFilePath = Paths.get(filePath);
        String expectedText = Files.readString(realFilePath);
        String parsedFileHandlerText = fileHandler.readFile(realFilePath);
        assertEquals(expectedText,parsedFileHandlerText,"File content matches!");
    }

    void readFile_whenFileDoesntExist() //this is for when a file doesn't exist...
    {
        FileHandler fileHandler = new FileHandler();
        Path pathDoesNotExist = Path.of("this_is_a_file_that_doesn't_really_exist_LOL.txt");

        IOException exception = assertThrows(IOException.class, () ->
                fileHandler.readFile(pathDoesNotExist));

        assertEquals("File not Found!", exception.getMessage());
    }
}