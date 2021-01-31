package functional.functionalcombinatorpattern;

import constants.ValidationResult;
import model.Member;

import java.time.LocalDate;

public class MemberRegistrationTest {
    public static void main(String[] args) {
        ValidationResult validationResult = MemberRegistrationValidator
                .isEmailValid()
                .and(MemberRegistrationValidator.isPhoneNumberValid())
                .and(MemberRegistrationValidator.isAdult())
                .apply(new Member("John" ,
                                "Smith",
                        "+01233212",
                        "smithgmail.com",
                        LocalDate.of(1990 , 1, 1)));


        if (!validationResult.equals(ValidationResult.SUCCESS))
            throw new IllegalStateException(validationResult.name());
    }
}
