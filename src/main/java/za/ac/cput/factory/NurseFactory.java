package za.ac.cput.factory;

import za.ac.cput.domain.Nurse;
import za.ac.cput.util.StringHelper;

/*
    NurseFactory.java
    Factory for Nurses
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public class NurseFactory {
    public static Nurse createNurse(String nurseID, String nurseFirstName, String nurseLastName) {
        StringHelper.checkStringParam("nurseID", nurseID);
        StringHelper.checkStringParam("nurseFirstName", nurseFirstName);
        StringHelper.checkStringParam("nurseLastName", nurseLastName);

        return new Nurse.Builder().nurseID(nurseID).nurseFirstName(nurseFirstName).nurseLastName(nurseFirstName).build();
    }
}
