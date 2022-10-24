package za.ac.cput.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*
    Patient.java
    Entity: Patient
    Author: Ishmail T Mgwena (215088417)
    Date: 05 August 2022
*/
@ToString
@Getter
@NoArgsConstructor
public class Patient {
    private String patIdNum;
    private String patFirstName;
    private String patLastName;
    private String patAddress;
    private String patCellNum;

    private Patient(Builder builder) {
        this.patIdNum = builder.patIdNum;
        this.patFirstName = builder.patFirstName;
        this.patLastName = builder.patLastName;
        this.patAddress = builder.patAddress;
        this.patCellNum = builder.patCellNum;
    }

    public static class Builder {
        private String patIdNum, patFirstName, patLastName, patAddress, patCellNum;

        public Builder setPatIdNum(String patIdNum) {
            this.patIdNum = patIdNum;
            return this;
        }

        public Builder setPatFirstName(String patFirstName) {
            this.patFirstName = patFirstName;
            return this;
        }

        public Builder setPatLastName(String patLastName) {
            this.patLastName = patLastName;
            return this;
        }

        public Builder setPatAddress(String patAddress) {
            this.patAddress = patAddress;
            return this;
        }

        public Builder setPatCellNum(String patCellNum) {
            this.patCellNum = patCellNum;
            return this;
        }
        public Builder copy(Patient patient){
            this.patIdNum = patient.patIdNum;
            this.patFirstName = patient.patFirstName;
            this.patLastName = patient.patLastName;
            this.patAddress = patient.patAddress;
            this.patCellNum = patient.patCellNum;
            return this;
        }
        public Patient build() {return new Patient(this);}
    }
}



