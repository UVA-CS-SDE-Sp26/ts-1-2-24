import java.util.OptionalInt;

public class ArgParser {
    public static OptionalInt parseArgs(String[] args) throws NumberFormatException {
        if (args == null || args.length == 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(Integer.parseInt(args[0]));
    }
}
