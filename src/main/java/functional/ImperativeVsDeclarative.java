package functional;


import constants.Gender;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ImperativeVsDeclarative {

    public static void main(String[] args) {


        // Initiate the list
        List<Person> personList = List.of(new Person("Eren", Gender.MALE),
                                    new Person("Armin", Gender.MALE),
                                    new Person("Mikasa", Gender.FEMALE),
                                    new Person("Hanji", Gender.FEMALE),
                                    new Person("Levi", Gender.MALE),
                                    new Person("Jean", Gender.MALE),
                                    new Person("Sasha", Gender.FEMALE),
                                    new Person("Connie", Gender.MALE));


        // Imperative approach

        System.out.println("Imperative Approach");

        List<Person> maleList   = new ArrayList<>(); // List of male
        List<Person> femaleList = new ArrayList<>(); // List of female

        for (Person p: personList){ // Track people, add into the lists according to their genders
            if (p.getGender().equals(Gender.MALE))
                maleList.add(p);
            else
                femaleList.add(p);
        }

        // Print list of male
        System.out.println("List of male");

        for (Person p: maleList)
            System.out.println(p);

        // Print list of female
        System.out.println("List of female");

        for (Person p: femaleList)
            System.out.println(p);


        System.out.println("******************");


        // Declarative approach

        System.out.println("Declarative Approach");


        // Print list of male
        System.out.println("List of male");

        personList.stream()
                    .filter(p -> p.getGender().equals(Gender.MALE))
                    .forEach(System.out::println);

        // Print list of female
        System.out.println("List of female");

        // Use of predicate
        Predicate<Person> personPredicate =  p -> p.getGender().equals(Gender.FEMALE);
        personList.stream()
                .filter(personPredicate)
                .forEach(System.out::println);

    }
}


