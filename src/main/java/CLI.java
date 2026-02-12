import java.nio.file.Path;
import java.util.List;
import java.util.OptionalInt;

public class CLI {
    private FileLister fileLister;
    private FileReader fileReader;
    public static String INVALID_FILE_NUMBER_MSG = "Invalid file number. Run the program without any arguments to see the list of files.";
    public CLI(FileLister fileLister, FileReader fileReader) {
        this.fileLister = fileLister;
        this.fileReader = fileReader;
    }
    public String getOutput(String[] args) {
        try {
            OptionalInt fileNum = ArgParser.parseArgs(args);
            List<Path> pathList = fileLister.getFileList();
            if (!fileNum.isPresent()) {
                // Print file list
                String msg = "";
                for (int i = 0; i < pathList.size(); i++) {
                    msg += String.format("%02d %s%n", i + 1, pathList.get(i).getFileName());
                }
                return msg;
            } else {
                // Check if file is in pathList
                try {
                    Path filePath = pathList.get(fileNum.getAsInt() - 1);
                    // Print file contents
                    return fileReader.readFile(filePath);
                } catch (IndexOutOfBoundsException e) {
                    return INVALID_FILE_NUMBER_MSG;
                }
            }
        } catch (NumberFormatException e) {
            return INVALID_FILE_NUMBER_MSG;
        }
    }
}
