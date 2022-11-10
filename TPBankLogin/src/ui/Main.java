/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Locale;
import bo.LoginSystem;
import utils.Validation;

/**
 *
 * @author duytr
 */
public class Main {

    public static void main(String[] args) {
        Locale Vietnamese = new Locale("vi");
        Locale English = new Locale("en");
        String menu = "\n------- TP Bank Login Program --------\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit\n"
                + "Enter choice: ";
            int choice = Validation.getInt(menu, "Please enter Integer Number!", 1, 3);
            switch (choice) {
                case 1:
                    LoginSystem loginVI = new LoginSystem(Vietnamese);
                    loginVI.TPBankLoginSystem();
                    break;
                case 2:
                    LoginSystem loginEN = new LoginSystem(English);
                    loginEN.TPBankLoginSystem();
                    break;
                case 3:
                    return;
            }
        }
}
