package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sun.tools.javac.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class DriverTest {

  @Test
  public void testDriver() throws IOException {

    Driver d = new Driver();

    String[] args = new String[] {"src/test/resources", "filename",
        "src/examples/"};
    d.main(args);

  }
}