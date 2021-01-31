package functional;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        // Standart function example
        System.out.println("Standart function example: " + getElements());
        System.out.println();

        // Supplier example
        System.out.println("Supplier example: " + getElementsSupplier.get());
        System.out.println();
    }

    // Standart function example
    public static List<String> getElements(){
        return List.of("Water", "Earth", "Fire", "Air");
    }

    // Supplier example
    public static Supplier<List<String>> getElementsSupplier = () -> List.of("Water", "Earth", "Fire", "Air");

}
