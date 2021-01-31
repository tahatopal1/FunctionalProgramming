package functional;

import model.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Customer customer = new Customer("Taha", "Topal", 25);

        // Standart function example
        System.out.println("Standart function example");
        greetCustomer(customer);

        // Consumer example
        System.out.println("Consumer example");
        greetCustomerConsumer.accept(customer);

        // Standart function example with two parameters
        System.out.println("Standart function example with two parameters");
        greetCustomerTwoParams(customer, false);

        // BiConsumer example
        System.out.println("BiConsumer example");
        greetCustomerBiConsumer.accept(customer, false);

    }

    // Standart function
    public static void greetCustomer(Customer customer){
        System.out.println("Greetings: " + customer.getName() + " " + customer.getSurname());
    }

    // Consumer example
    public static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println(customer);

    // Standart function with two parameters
    public static void greetCustomerTwoParams(Customer customer, boolean bool){
        System.out.println("Greetings: " + customer.getName() + " " + ((bool) ? customer.getSurname() : (customer.getSurname().charAt(0) + "****")));
    }

    // BiConsumer example
    public static BiConsumer<Customer, Boolean> greetCustomerBiConsumer
            = (customer, aBoolean)
            -> System.out.println("Greetings: "
                + customer.getName()
                + " "
                + ((aBoolean) ? customer.getSurname() : (customer.getSurname().charAt(0) + "****")));

}
