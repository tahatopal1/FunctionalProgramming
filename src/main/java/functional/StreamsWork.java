package functional;

import model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsWork {
    public static void main(String[] args) {
        List<Customer> list = List.of(new Customer("LeBron", "James", 35),
                                        new Customer("Stephen", "Curry", 30),
                                        new Customer("Jimmy", "Butler", 29),
                                        new Customer("James", "Harden", 33));

        // Stream to names
        System.out.println("Stream to names");
        list.stream()
                .map(customer -> customer.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        // Stream to length of surnames
        System.out.println("Stream to length of surnames");
        list.stream()
                .map(customer -> customer.getSurname())
                .mapToInt(String::length)
                //.boxed()
                //.collect(Collectors.toList()) // could be used if wanted to collect
                .forEach(System.out::println);



        System.out.println();

        // Stream to ages
        System.out.println("Stream to ages");
        list.stream()
                .map(customer -> customer.getAge())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // All match to age is greater than 25
        System.out.println("All match to age is greater than 25");
        Boolean allMatch = list.stream()
                .map(customer -> customer.getAge())
                .allMatch(integer -> integer > 25);

        System.out.println("All match result: " + allMatch);

        // Any match to age is greater than 40
        System.out.println("Any match to age is greater than 40");
        Boolean anyMatch = list.stream()
                .map(customer -> customer.getAge())
                .anyMatch(integer -> integer > 40);

        System.out.println("Any match result: " + anyMatch);




    }
}
