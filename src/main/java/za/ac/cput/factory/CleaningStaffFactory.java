package za.ac.cput.factory;
import za.ac.cput.domain.CleaningStaff;
import za.ac.cput.util.StringHelper;

//Sinazo Mehlomakhulu(216076498)

public class CleaningStaffFactory {
    public static CleaningStaff createCleaningStaff(String employeeId, String employeeFirstName, String employeeLastName) {
        StringHelper.checkStringParam("employeeId", employeeId);
        StringHelper.checkStringParam("employeeFirstName", employeeFirstName);
        StringHelper.checkStringParam("employeeLastName", employeeLastName);
        return new CleaningStaff.Builder().employeeId(employeeId).employeeFirstName(employeeFirstName).employeeLastName(employeeLastName).build();
    }
}
