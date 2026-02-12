import java.io.File; //this is so we can use files
import java.io.IOException; //this is so if we are unable to load or find a file, we can catch that error
import java.nio.file.Files; //another thing for files
import java.nio.file.Paths; //another thing for Paths
import java.nio.file.Path; //last thing for Paths (so we can use them in our directories)

public class FileHandler implements FileReader{

    @Override
    public String readFile(Path path) throws IOException{
        if(!Files.exists(path)) //if the file path doesn't exist
        {
           throw new IOException("File not Found!"); //it'll throw an exception, and print the message that the file wasn't found
        }
        return Files.readString(path); //otherwise, it'll just return the File's contents as a string!
    }
}
