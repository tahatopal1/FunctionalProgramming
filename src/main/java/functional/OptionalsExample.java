package functional;

import lombok.SneakyThrows;

import java.util.Optional;

public class OptionalsExample {
    @SneakyThrows
    public static void main(String[] args) {

        // Default value instead of null
        System.out.println("Default value example");
        Object value = Optional.ofNullable(null)
                                        .orElseGet(() -> "Default value");
        System.out.println("value = " + value);
        System.out.println();

        // Of value example
        System.out.println("Of value example");
        value = Optional.ofNullable("Example value")
                                        .orElseGet(() -> "Default Value");

        System.out.println("value = " + value);
        System.out.println();

        // If present example
        System.out.println("If present example");

        Optional.ofNullable("Taha")
                .ifPresent(name -> System.out.println("Greetings " + name + "!"));

        System.out.println();

        // If present or else example
        System.out.println("If present or else example");

        Optional.ofNullable(null)
                .ifPresentOrElse(name -> System.out.println("Greetings " + name + "!"),
                        () -> System.out.println("There is no name to greet"));

        System.out.println();

        // Or else throw example
        System.out.println("Or else throw example");
        value = Optional.ofNullable(null)
                                        .orElseThrow(() -> new Exception("Example exception"));




    }
}
