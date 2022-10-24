package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.util.StringHelper;

/*
    DriverFactory.java
    Factory for Driver
    Author: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 14 August 2022
*/

public class DriverFactory {

    public static Driver createDriver(String driverID, String driverFirstName, String driverLastName, String driverLicenseNum) {
        StringHelper.checkStringParam("driverID", driverID);
        StringHelper.checkStringParam("driverFirstName", driverFirstName);
        StringHelper.checkStringParam("driverLastName", driverLastName);
        StringHelper.checkStringParam("driverLicenseNum", driverLicenseNum);

        return new Driver.Builder().driverID(driverID).driverFirstName(driverFirstName).driverLastName(driverLastName).driverLicenseNum(driverLicenseNum).build();
    }
}
