package za.ac.cput.factory;

import za.ac.cput.domain.Secretary;
import za.ac.cput.util.StringHelper;

public class SecretaryFactory {
    public static Secretary createSecretary(String secID, String secFirstName, String secLastName)
    {
        StringHelper.checkStringParam("secID", secID);
        StringHelper.checkStringParam("secFirstName", secFirstName);
        StringHelper.checkStringParam("secLastName", secLastName);

        return Secretary.builder().secID(secID).secFirstName(secFirstName).secLastName(secLastName).build();
    }
}
