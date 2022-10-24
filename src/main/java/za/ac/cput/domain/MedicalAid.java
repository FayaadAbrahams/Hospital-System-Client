package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.util.Objects;

/*
    MedicalAid.java
    Entity for the Medical Aid
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
@Getter
@ToString
@NoArgsConstructor
public class MedicalAid {

    @Id
    private String medicalNum;
    @NotNull
    private String medicalName;
    private String medicAddr;


    public MedicalAid(Builder builder) {
        this.medicalNum = builder.medicalNum;
        this.medicalName = builder.medicalName;
        this.medicAddr = builder.medicalAddr;


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalAid that = (MedicalAid) o;
        return medicalNum == that.medicalNum && medicalName.equals(that.medicalName) && medicAddr.equals(that.medicAddr);
    }

    @Override

    public int hashCode() {
        return Objects.hash(medicalNum, medicalName,medicAddr);
    }

    public static class Builder {
        private String medicalNum;
        private String medicalName;
        private String medicalAddr;



        public Builder medicalNum(String medicalNum) {
            this.medicalNum = medicalNum;
            return this;
        }

        public Builder medicalName(String medicalName) {
            this.medicalName = medicalName;
            return this;
        }

        public Builder medicalAddr(String medicalAddr) {
            this.medicalAddr = medicalAddr;
            return this;
        }



        public Builder copy(MedicalAid medicalAid) {
            this.medicalNum = medicalAid.medicalNum;
            this.medicalName=medicalAid.medicalName;
            this.medicalAddr=medicalAid.medicAddr;
            return this;
        }
        public MedicalAid build() {
            return new MedicalAid(this);

        }
    }
}



