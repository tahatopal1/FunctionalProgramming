package functional;

import java.util.function.Consumer;

public class MethodCallbackExample {
    public static void main(String[] args) {

        System.out.println("First greetings example");
        greetings("Taha", (str) -> System.out.println(str) );
        System.out.println();

        System.out.println("Second greetings example");
        greetings(null, s -> System.out.println());
        System.out.println();

        System.out.println("Runnable example");
        hello(null, () -> System.out.println("There is no name indicated"));


    }

    public static void greetings(String name, Consumer<String> consumer){
        if (name != null){
            System.out.println("Greetings " + name + "!");
        }else{
            consumer.accept("There is no name indicated");
        }
    }

    public static void hello(String name, Runnable runnable){
        if (name != null){
            System.out.println("Greetings " + name + "!");
        }else{
            runnable.run();
        }
    }
}
