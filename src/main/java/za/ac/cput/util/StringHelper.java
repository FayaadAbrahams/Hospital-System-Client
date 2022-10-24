package za.ac.cput.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/*
    StringHelper.java
    Helper Entity for the Factories
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public class StringHelper {
    public static boolean isEmptyOrNull(String str) {
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str) {
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static String generateUnqiueID(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }
}
