/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;
import utils.Validation;

/**
 *
 * @author duytr
 */
public class Captcha {

    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    private String generateCaptcha(int length) {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String generatedCaptcha = "";
        for (int i = 0; i < length; i++) {
            generatedCaptcha += alphanumeric.charAt(new Random().nextInt(alphanumeric.length()));
        }
        return generatedCaptcha;
    }

    public String getGeneratedCaptcha() {
        this.captcha = generateCaptcha(6);
        return captcha;
    }

    public boolean isCaptchaValid(String inputCaptcha) {
        return Validation.verifyCaptcha(inputCaptcha, captcha);
    }
}
