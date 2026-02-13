import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WorkingDirectoryFileListerTest {
    @Test
    void testGetFileListEmptyFolder() {
        WorkingDirectoryFileLister lister = new WorkingDirectoryFileLister();
        List<Path> files = lister.getFileList();
        assertNotNull(files);
    }
    @Test
    void testGetFileListFolderIsNotEmpty() {
        WorkingDirectoryFileLister lister = new WorkingDirectoryFileLister();
        List<Path> files = lister.getFileList();
        assertNotNull(files);
        if (!files.isEmpty()) {
            Path firstFile = files.get(0);
            assertTrue(firstFile.toString().contains("data"));
        }
    }
    @Test
    void testBadFilePath() {
        WorkingDirectoryFileLister lister = new WorkingDirectoryFileLister("Bad");
        List<Path> files = lister.getFileList();
        assertNotNull(files);
        assertTrue(files.isEmpty());
    }
}

