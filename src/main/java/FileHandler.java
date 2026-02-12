import java.io.File; //this is so we can use files
import java.io.IOException; //this is so if we are unable to load or find a file, we can catch that error
import java.nio.file.Files; //another thing for files
import java.nio.file.Paths; //another thing for Paths
import java.nio.file.Path; //last thing for Paths (so we can use them in our directories)

public class FileHandler implements FileReader{

//    public String readFile(String filename) throws IOException
//    {
//       // Path filePath = Paths.get(dataDirectory, filename); //this will allow us to look within the Data directory, and get the file path for the file we're looking for
//        if(!Files.exists(filePath)) //if the file we're trying to read doesn't exist...
//        {
//            throw new IOException("File not found!");
//        }
//        return Files.readString(filePath); //this will read the file as a string
//    }

    @Override
    public String readFile(Path path) throws IOException{
        if(!Files.exists(path))
        {
           throw new IOException("File not Found!");
        }

        return Files.readString(path);
    }
}
