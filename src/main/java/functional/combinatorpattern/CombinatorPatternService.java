package functional.combinatorpattern;

import model.Member;

import java.time.LocalDate;
import java.time.Period;

public class CombinatorPatternService {

    private boolean isEmailValid(String email){
        return email.contains("@"); // Not a real validation, just a simple example
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    public boolean isValid(Member member){
        return isEmailValid(member.getEmail()) && isPhoneNumberValid(member.getPhoneNumber()) && isAdult(member.getBirthDate());
    }
}
