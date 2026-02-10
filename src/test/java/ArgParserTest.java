import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

public class ArgParserTest {
    @Test
    void testParseArgsWithFileNumber() {
        OptionalInt result = ArgParser.parseArgs(new String[]{"01"});
        assertTrue(result.isPresent());
        assertEquals(1, result.getAsInt());
    }

    @Test
    void testParseEmptyArgs() {
        OptionalInt result = ArgParser.parseArgs(new String[]{});
        assertFalse(result.isPresent());
    }

    @Test
    void testParseArgsInvalidFileNumber() {
        assertThrows(NumberFormatException.class, () -> ArgParser.parseArgs(new String[]{"abc"}));
    }
}
