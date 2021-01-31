package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private String    name;
    private String    surname;
    private String    phoneNumber;
    private String    email;
    private LocalDate birthDate;
}
