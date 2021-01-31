package functional.functionalcombinatorpattern;

import constants.ValidationResult;
import model.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface MemberRegistrationValidator extends Function<Member, ValidationResult> {

    static MemberRegistrationValidator isEmailValid(){
        return member -> member.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static MemberRegistrationValidator isPhoneNumberValid(){
        return member -> member.getPhoneNumber().startsWith("+0") ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static MemberRegistrationValidator isAdult(){
        return member -> Period.between(member.getBirthDate(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default MemberRegistrationValidator and(MemberRegistrationValidator other){
        return member -> {
          ValidationResult result = this.apply(member);
          return result.equals(ValidationResult.SUCCESS) ? other.apply(member) : result;
        };
    }

}
