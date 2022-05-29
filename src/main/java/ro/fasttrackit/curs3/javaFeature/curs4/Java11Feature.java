package ro.fasttrackit.curs3.javaFeature.curs4;

import javax.annotation.processing.Generated;
import java.beans.BeanProperty;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

import static java.nio.file.StandardOpenOption.APPEND;

public class Java11Feature {
  public static void main(String[] args) {
    stringMethods ();
    lambdaAnnotations ();
    filesMethod();
  }

  private static void filesMethod() {
    try {
      System.out.println (Files.writeString (Path.of ("simple.txt"), "My line"));
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }

  private static void lambdaAnnotations() {
    Function<String, String> logic = (@Generated (value= "") String a) -> a + a + "test";
  }

  private static void stringMethods() {
    String value = " ";
    System.out.println (value.isBlank ());
    System.out.println (value.isEmpty ());
    if (value.trim ().isEmpty ()) {

    }
    String text = " java ";
    System.out.println (text.repeat (10));

    String unicode = "\u0000   java    ";
    System.out.println (unicode.trim ());
    System.out.println (unicode.strip ());
    System.out.println (unicode.stripTrailing () + "|");
    System.out.println (unicode.stripIndent () + "|");
    System.out.println ("|" + unicode.stripLeading () + "|");
  }
}
