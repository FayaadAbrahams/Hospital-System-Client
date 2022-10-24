package za.ac.cput.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Getter
@ToString
@Builder
@NoArgsConstructor
public class Doctor {

    private String docID;

    private String firstName;

    private String lastName;

    private String cellNum;

    public Doctor(String docID, String firstName, String lastName, String cellNum) {
        this.docID = docID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellNum = cellNum;
    }
}
