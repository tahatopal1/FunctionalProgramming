package functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // Using standart function
        int standart = incrementByFive(5);
        System.out.println("standart result: " + standart);

        // Using improved function
        int improved = incrementByFiveFunc.apply(5);
        System.out.println("improved result: " + improved);

        // Combining two function
        int combinedResult = incrementByFiveThenMultiplyByTen.apply(5);
        System.out.println("combined result: " + combinedResult);

        // Using standart function with two parameters
        System.out.println("function result (two parameters): " + multiply(3,5));

        // Using BiFunction
        System.out.println("bifunction result: " + multiplyTwoNumbers.apply(3,5));

    }

    // Standart function
    public static Integer incrementByFive(Integer i){
        return i + 5;
    }

    // Standart function with two parameters
    public static Integer multiply(Integer x, Integer y){
        return x * y;
    }

    // Function with 'Function' class
    public static Function<Integer, Integer> incrementByFiveFunc = i -> i + 5;

    // A new function to be combined with another one
    public static Function<Integer, Integer> multiplyByTen = i -> i * 10;

    // Combined function
    public static Function<Integer, Integer> incrementByFiveThenMultiplyByTen = incrementByFiveFunc.andThen(multiplyByTen);

    // BiFunction (takes two parameters)
    public static BiFunction<Integer, Integer, Integer> multiplyTwoNumbers = (x,y) -> x * y;

}
