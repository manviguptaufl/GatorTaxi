import java.io.*;
import java.util.*;

// A utility class that collects and writes the output required to be printed to the specified file.
public class OutputParser {
    // We'll collect all the print statements into one StringBuilder object
    // and finally writes it to the file on program exit.
    private static StringBuilder output = new StringBuilder();

    // Empty node tuple, to be printed when node requested to be print is not found.
    private static final String emptyNodeTuple = "(0,0,0)";

    // Name of the output file.
    private static final String outputFilename = "output_file.txt";

    // Appends the details of the ride to be printed to the output when Print operation is to be performed.
    public static void addRideTuple(RedBlackNode node) {
        output.append(((node != null) ? node.toString() : "(0,0,0)") + "\n");
    }

    // Appends the details of the rides to be printed to the output when Print(X,Y) operation is to be performed.
    public static void addBetweenRides(List<RedBlackNode> nodes) {
        if (nodes.size() > 0) {
            for (RedBlackNode node : nodes) {
                output.append(((node != null) ? node.toString() : emptyNodeTuple) + ",");
            }
            // Remove extra comma.
            output.setLength(output.length() - 1);
            output.append("\n");
        } else {
            output.append(emptyNodeTuple + "\n");
        }
    }

    // Appends the error message to the output when any error occurs.
    public static void addErrorMessage(String error) {
        output.append(error + "\n");
    }

    public static void printN(HeapNode m) {
        output.append(m.toString());
    }

    public static void appendString(String s) {
        output.append(s + "\n");
    }

    // Prints the final output to the output file.
    public static void print() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilename))) {
            bufferedWriter.write(output.toString().trim());
        }
    }
}
