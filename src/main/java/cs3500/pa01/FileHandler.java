package cs3500.pa01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Class to write the file at the given output location
 */
public class FileHandler {

  /**
   * Writes the contents in each SummarizedFile on a single file it creates at the specified
   * output location
   */
  public void readFiles(ArrayList<SummarizedFile> summarizedFiles,
                        Path outputPath) throws IOException {


    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < summarizedFiles.size(); i++) {
      ArrayList<String> fileContents = summarizedFiles.get(i).getContents();
      for (int j = 0; j < fileContents.size(); j++) {
        builder.append(fileContents.get(j));
        builder.append("\n");
      }
    }

    FileWriter f = new FileWriter(outputPath.toString());
    f.write(builder.toString());
    f.close();

  }
}