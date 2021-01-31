package functional;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiWorks {
    public static void main(String[] args) {
        // Some features with streams

        System.out.println("First example:");
        IntStream
                .range(1, 10) // defines an integer stream from 1 to 10
                .skip(5) // skips first 5 items
                .forEach(System.out::print); // prints all
        System.out.println();

        System.out.println("Second example: ");
        System.out.println(IntStream
                .range(1, 10) // defines an integer stream from 1 to 10
                .sum());
        System.out.println();

        System.out.println("Third example");
        Stream.of("Ava", "Aneri", "Alberto") // defines a string stream
                .sorted() // sorts by alphabetic order
                .findFirst() // finds the first one (optional value)
                .ifPresent(System.out::println); // prints the result
        System.out.println();

        System.out.println("Forth example");
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Shivika"};
        Arrays.stream(names) // Injects the string array into the stream
                .filter(s -> s.startsWith("A")) // filters the strings start with 'A'
                .sorted() // sorts by alphabetic order
                .forEach(System.out::println); // prints all
        System.out.println();

        System.out.println("Fifth example");
        Arrays.stream(new int[]{1,4,5,12,17,26,33,39,41,50}) // Injects the integer array into the stream
                .map(x -> x * x) // converts the numbers to second power
                .average() // takes the average
                .ifPresent(System.out::println); // prints the result
        System.out.println();

        System.out.println("Seventh example");
        List<String> people = Arrays.asList(names); // Converts array to the lsit
        people.stream() // Gets the stream
                .map(String::toLowerCase) // converts all letters inside the strings to lowercase
                .filter(x -> x.startsWith("s")) // filters the strings start with 's'
                .forEach(System.out::println); // prints all
        System.out.println();


        System.out.println("Eighth example");
        try {
            Stream<String> bands = Files.lines(Paths.get("src\\main\\java\\functional\\bands.txt")); // Initiates a string stream by using file
            bands
                    .sorted() // sorts the band names
                    .filter(x -> x.length() > 13) // filters words greater than 13 in length
                    .forEach(System.out::println); // prints all
                    bands.close(); // closes the string
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ninth example");
        try {
            List<String> bands2 = Files.lines(Paths.get("src\\main\\java\\functional\\bands.txt")) // Initiates a string stream by using file
                    .filter(x -> x.contains("en")) // filters the words that contain 'en'
                    .collect(Collectors.toList()); // collects them into a list
            bands2.forEach(System.out::println); // prints all
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Tenth example");
        try {
            Stream<String> bands = Files.lines(Paths.get("src\\main\\java\\functional\\bands.txt")); // Initiates a string stream by using file
            int rowCount = (int) bands
                    .map(x -> x.split(" ")) // splits the band names by space
                    .filter(x -> x.length > 1) // filters splitted results that have more than 1 word
                    .count(); // counts the result
            System.out.println(rowCount); // prints the result
            bands.close(); // closes the string
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Eleventh example");
        double total = Stream.of(11.2, 2.6, 4.1) // Defines a double stream
                .reduce(-1.0, (Double a, Double b) -> a + b); // sums all the values in stream by starting with -1.0 value
        System.out.println(total); // prints the result
        System.out.println();

        System.out.println("Twelfth example");
        IntSummaryStatistics summaryStatistics = IntStream.of(5,1,8,11,16,27,32,38,41) // Initiates an integer stream
                .summaryStatistics(); // gets the summary of statisctics
        System.out.println(summaryStatistics);

    }
}
