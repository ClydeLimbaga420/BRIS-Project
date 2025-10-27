package codinpad.model;//change this

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;
    private String suffix;
    private int age;
    private String gender;
    private String birthdate;
    private String civilStatus;
    private String occupation;
    private String contactNumber;
    private String voterStatus;
    private String emailAddress;
    private int numberOfHouseholdMembers;
    private String religion;
    private boolean pwd;
    private String bloodType;
    private String educationalAttainment;
}
