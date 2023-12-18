package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * Tests the FileHandler class
 */
class FileHandlerTest {

  /**
   * Tests the readFiles() method that reads the contents of each SummarizedFile and writes it on
   * the file at the given output path
   */
  @Test
  public void testReadFiles() throws IOException {

    ArrayList<SummarizedFile> summarizedFiles = new ArrayList<SummarizedFile>();

    ArrayList<String> exContent = new ArrayList<String>();
    SummarizedFile array = new SummarizedFile("alpha.md", 4, 9, exContent);
    SummarizedFile vector = new SummarizedFile("beta.md", 2, 6, exContent);

    summarizedFiles.add(array);
    summarizedFiles.add(vector);

    Path outputPath = (Path.of("examples/studyguide.md"));

    FileHandler fh = new FileHandler();

    fh.readFiles(summarizedFiles, outputPath);

    File f = new File(outputPath.toString());

    Scanner sc;
    try { // The file may not exist, in which case we need to handle that error (hence try-catch)
      sc = new Scanner(new FileInputStream(f));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    if (sc.hasNextLine()) {
      assertEquals("# Hello", sc.nextLine());
    }
  }
}