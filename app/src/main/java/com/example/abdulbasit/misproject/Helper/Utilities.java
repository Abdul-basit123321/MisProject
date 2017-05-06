package com.example.abdulbasit.misproject.Helper;

/**
 * Created by Abdul basit on 5/6/2017.
 */

public class Utilities {

    public static boolean isEmptyOrNull(String data) {
        if (data == null || data.length() == 0) {
            return true;
        }
        return false;
    }


    public static boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._+-]+@[a-z0-9._-]+\\.+[a-z]+";

        // onClick of button perform this simplest code.
        if (email.matches(emailPattern)) {
            return true;
        } else {
            return false;
        }
    }
}
