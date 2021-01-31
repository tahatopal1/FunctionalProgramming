package functional.combinatorpattern;

import model.Member;

import java.time.LocalDate;

public class CombinatorPatternExample {
    public static void main(String[] args) {
        System.out.println("Validation result: "
                + new CombinatorPatternService().isValid
                            (new Member("Jack", "Smith", "+011122233", "smith@gmail.com"
                                    , LocalDate.of(1995, 01, 01))));
    }
}
