package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Represents the driver and main class
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) throws IOException {

    Path startPath = Path.of(args[0]);

    String flag = args[1];

    Path outputPath = Path.of(args[2]);

    FileSystemVisitor visitor = new FileSystemVisitor();

    FileHandler fileHandler = new FileHandler();

    try {
      Files.walkFileTree(startPath, visitor);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    ArrayList<SummarizedFile> files = visitor.getList();
    ArrayList<SummarizedFile> sortedFiles = visitor.getSortedList(flag, files);
    fileHandler.readFiles(sortedFiles, outputPath);
  }
}