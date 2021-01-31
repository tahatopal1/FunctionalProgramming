package functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        // Standart boolean function example
        System.out.println("Standart function example:");
        System.out.println("is 0900162233 valid? -> " + isValid("0900162233"));
        System.out.println("is 1122213341 valid? -> " + isValid("1122213341"));
        System.out.println();

        // Predicate example
        System.out.println("Predicate example");
        System.out.println("is 0900162233 valid? -> " + isValidPredicate.test("0900162233"));
        System.out.println("is 1122213341 valid? -> " + isValidPredicate.test("1122213341"));
        System.out.println();

        // Standart combined example
        System.out.println("Standart combined example");
        System.out.println("is 0900162233 valid? -> " + (isValid("0900162233") && isValidContains("0900162233")));
        System.out.println("is 1122213341 valid? -> " + (isValid("1122213341") && isValidContains("1122213341")));
        System.out.println();

        // Predicate combined example
        System.out.println("Standart predicate example");
        System.out.println("is 0900162233 valid? -> " + isValidPredicate.and(isValidContainsPredicate).test("0900162233"));
        System.out.println("is 1122213341 valid? -> " + isValidPredicate.and(isValidContainsPredicate).test("1122213341"));
        System.out.println();

        // BiPredicate example
        System.out.println("BiPredicate example");
        System.out.println("is 0900162233 valid? -> " + isValidBiPredicate.test("0900162233", "0900"));
        System.out.println("is 1122213341 valid? -> " + isValidBiPredicate.test("1122213341", "0900"));
        System.out.println();
    }

    // Standart boolean function
    public static boolean isValid(String str){
        return str.startsWith("0900");
    }

    // Predicate example
    public static Predicate<String> isValidPredicate = s -> s.startsWith("0900");

    // Another standart boolean function
    public static boolean isValidContains(String str){
        return str.contains("6");
    }

    // Another predicate example
    public static Predicate<String> isValidContainsPredicate = s -> s.contains("6");

    // BiPredicate example
    public static BiPredicate<String, String> isValidBiPredicate = (s, s2) -> s.startsWith(s2);


}
