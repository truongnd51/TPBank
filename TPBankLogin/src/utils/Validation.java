/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Validation {

    static Scanner scan = new Scanner(System.in);

    public static String getStringByRegex(String mess, String error, String regex) {
        String output;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine().trim();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String errorNumberFormat, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println("Please enter number in range [" + min + ", " + max + "]");
            } else {
                return ret;
            }
        }
    }

    public static boolean verifyCaptcha(String inputCaptcha, String generatedCaptcha) {
        if (!generatedCaptcha.contains(inputCaptcha)) {
            return false;
        }
        return true;
    }

    public static String getLanguage(Locale currentLocale, String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/Language", currentLocale);
        String value = resourceBundle.getString(key);
        return value;
    }
}
