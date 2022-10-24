package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

/*
    Driver.java
    Entity for Driver
    Author: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 4 August 2022
*/


public class Driver implements Serializable {
    private String driverID;
    private String driverFirstName;
    private String driverLastName;

    private String driverLicenseNum;

    public Driver(Builder builder) {
        this.driverID = builder.driverID;
        this.driverFirstName = builder.driverFirstName;
        this.driverLastName = builder.driverLastName;
        this.driverLicenseNum = builder.driverLicenseNum;
    }

    public Driver() {
    }

    public String getDriverID() {
        return driverID;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public String getDriverLicenseNum() {
        return driverLicenseNum;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverID='" + driverID + '\'' +
                ", driverFirstName='" + driverFirstName + '\'' +
                ", driverLastName='" + driverLastName + '\'' +
                ", driverLicenseNum='" + driverLicenseNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driverID.equals(driver.driverID) && driverFirstName.equals(driver.driverFirstName) && driverLastName.equals(driver.driverLastName) && driverLicenseNum.equals(driver.driverLicenseNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverID, driverFirstName, driverLastName, driverLicenseNum);
    }

    public static class Builder {
        private String driverID, driverFirstName, driverLastName, driverLicenseNum;

        public Builder driverID(String driverID) {
            this.driverID = driverID;
            return this;
        }

        public Builder driverFirstName(String driverFirstName) {
            this.driverFirstName = driverFirstName;
            return this;
        }

        public Builder driverLastName(String driverLastName) {
            this.driverLastName = driverLastName;
            return this;
        }

        public Builder driverLicenseNum(String driverLicenseNum) {
            this.driverLicenseNum = driverLicenseNum;
            return this;
        }

        public Builder copy(Driver driver) {
            this.driverID = driver.driverID;
            this.driverFirstName = driver.driverFirstName;
            this.driverLastName = driver.driverLastName;
            this.driverLicenseNum = driver.driverLicenseNum;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }
}


