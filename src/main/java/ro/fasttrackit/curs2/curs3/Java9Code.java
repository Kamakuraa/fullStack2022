package ro.fasttrackit.curs2.curs3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java9Code {
  public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
    processApi ();
//    Thread.sleep (10000000L);
    tryWithResources ();
    completablefuture ();
    optionalMethod ();
    streamImprovements ();

    httpClient();
  }

  private static void httpClient() throws IOException, InterruptedException, URISyntaxException {
    HttpRequest request = HttpRequest.newBuilder ()
      .uri (new URI ("https://postman-echo.com/get"))
      .GET ()
      .build ();

    Optional.ofNullable (HttpClient
      .newBuilder ()
      .build ()
      .send (request, HttpResponse.BodyHandlers.ofString ())
      .body ())
      .ifPresent (System.out::println);
  }

  private static void streamImprovements() {
    IntStream.range (1, 100);
    OptionalDouble average = IntStream.rangeClosed (1, 100)
      .average ();
    System.out.println (average.orElse (1));

    IntStream.iterate (0, i -> i < 100, i -> i + 1)
      .forEach (System.out::println);

    System.out.println (Stream.of (1, 2, 3, 4)
      .takeWhile (i -> i < 3)
      .map (i -> i + " elem")
      .collect (Collectors.joining (",")));
  }

  private static void optionalMethod() {
    Optional.ofNullable ("a")
      .ifPresentOrElse (value -> System.out.println (value), () -> System.out.println ("dosent exist"));
  }

  private static void completablefuture() throws InterruptedException {
    Executor executor = CompletableFuture.delayedExecutor (3, TimeUnit.SECONDS);
    executor.execute (() -> System.out.println ("hello 3 sec"));
//    Thread.sleep (10000);
  }

  private static void tryWithResources() throws IOException {
    BufferedWriter writer = new BufferedWriter (new FileWriter ("index.txt"));
    try (writer) {
      writer.write ("break");
    }
  }

  private static void processApi() {
    ProcessHandle current = ProcessHandle.current ();
    System.out.println (current.info ());

    ProcessHandle.of (37189).ifPresent (Java9Code::doSomething);
  }

  private static void doSomething(ProcessHandle processHandle) {
    CompletableFuture<ProcessHandle> async = processHandle.onExit ();
    async.thenAccept (smallProcess -> System.out.println ("Process " + smallProcess.pid () + " died"));
  }
}

interface ProvideData {
  default String provideData() {
    String name = getName ();
    return name + " hello";
  }

  private String getName() {
    return "name";
  }
}

class MySmallProcess {
  public static void main(String[] args) throws InterruptedException {
    System.out.println (ProcessHandle.current ().pid ());
  }
}
