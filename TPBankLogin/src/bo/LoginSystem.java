/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import utils.Validation;
import entity.Captcha;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author duytr
 */
public class LoginSystem {

    private final Locale lang;
    private final Captcha captcha;

    public LoginSystem(Locale lang) {
        this.lang = lang;
        captcha = new Captcha();
    }

    private String inputAccountName() {
        String accountName = Validation.getStringByRegex(
                Validation.getLanguage(lang, "accountName"),
                Validation.getLanguage(lang, "invalidAccountName"), "^[\\d]{10}$");
        return accountName;
    }

    private String inputPassword() {
        String password = Validation.getStringByRegex(
                Validation.getLanguage(lang, "password"),
                Validation.getLanguage(lang, "invalidPassword"), "^(?=.*[0-9])((?=.*[a-z])|(?=.*[A-Z])).{8,31}$");
        return password;
    }

    private String inputCaptcha() {
        Scanner scan = new Scanner(System.in);
        String inputCaptcha;
        do {
            String generatedCaptcha = captcha.getGeneratedCaptcha();
            System.out.println(Validation.getLanguage(lang, "captcha") + generatedCaptcha);
            System.out.print(Validation.getLanguage(lang, "inputCaptcha"));
            inputCaptcha = scan.nextLine();
            if (!captcha.isCaptchaValid(inputCaptcha)) {
                System.out.println(Validation.getLanguage(lang, "invalidCaptcha"));
            }
        } while (!captcha.isCaptchaValid(inputCaptcha));

        System.err.println(Validation.getLanguage(lang, "loginSuccess"));
        return inputCaptcha;
    }

    public void TPBankLoginSystem() {
        inputAccountName();
        inputPassword();
        inputCaptcha();
    }
}
