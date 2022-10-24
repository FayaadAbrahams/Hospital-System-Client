package za.ac.cput.factory;

import za.ac.cput.domain.Doctor;
import za.ac.cput.util.StringHelper;

public class DoctorFactory {
    public static Doctor createDoctor(String docID, String firstName, String lastName, String cellNum)
    {
        StringHelper.checkStringParam("docID", docID);
        StringHelper.checkStringParam("docFirstName", firstName);
        StringHelper.checkStringParam("docLastName", lastName);
        StringHelper.checkStringParam("docCellNum", cellNum);

        return Doctor.builder().docID(docID).firstName(firstName).lastName(lastName).cellNum(cellNum).build();
    }
}
