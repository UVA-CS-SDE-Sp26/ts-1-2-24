import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MockFileLister implements FileLister {
    Map<Path, String> fileSystem;

    public MockFileLister(Map<Path, String> fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public List<Path> getFileList() {
        return fileSystem.keySet().stream().sorted().toList();
    }
}

class MockFileReader implements FileReader {
    Map<Path, String> fileSystem;

    public MockFileReader(Map<Path, String> fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public String readFile(Path path) {
        return fileSystem.get(path);
    }
}

class MockBrokenFileReader implements FileReader {
    @Override
    public String readFile(Path path) throws IOException {
        throw new IOException("Failed to read file");
    }
}

public class CLITest {
    @Test
    public void testGetFileList() {
        Map<Path, String> fileSystem = Map.of(Path.of("mango.txt"), "mango", Path.of("apple.txt"), "apple");
        CLI cli = new CLI(new MockFileLister(fileSystem), new MockFileReader(fileSystem));
        String output = cli.getOutput(new String[] {});
        assertNotNull(output);
        assertEquals("01 apple.txt 02 mango.txt".replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
    public void testGetInvalidFileNumber() {
        Map<Path, String> fileSystem = Map.of(Path.of("mango.txt"), "mango", Path.of("apple.txt"), "apple");
        CLI cli = new CLI(new MockFileLister(fileSystem), new MockFileReader(fileSystem));
        String output = cli.getOutput(new String[] {"abc"});
        assertNotNull(output);
        assertEquals(CLI.INVALID_FILE_NUMBER_MSG,output);
    }

    @Test
    public void testGetOutOfRangeFileNumber() {
        Map<Path, String> fileSystem = Map.of(Path.of("mango.txt"), "mango", Path.of("apple.txt"), "apple");
        CLI cli = new CLI(new MockFileLister(fileSystem), new MockFileReader(fileSystem));
        String output = cli.getOutput(new String[] {"03"});
        assertNotNull(output);
        assertEquals(CLI.INVALID_FILE_NUMBER_MSG,output);
    }

    @Test
    public void testGetSpecificFile() {
        Map<Path, String> fileSystem = Map.of(Path.of("mango.txt"), "mango", Path.of("apple.txt"), "apple");
        CLI cli = new CLI(new MockFileLister(fileSystem), new MockFileReader(fileSystem));
        String output = cli.getOutput(new String[] {"02"});
        assertNotNull(output);
        assertEquals("mango", output);
    }

    @Test
    public void testFileReadFailed() {
        Map<Path, String> fileSystem = Map.of(Path.of("mango.txt"), "mango", Path.of("apple.txt"), "apple");
        CLI cli = new CLI(new MockFileLister(fileSystem), new MockBrokenFileReader());
        String output = cli.getOutput(new String[] {"02"});
        assertNotNull(output);
        assertEquals(CLI.INVALID_FILE_NUMBER_MSG, output);
    }
}
