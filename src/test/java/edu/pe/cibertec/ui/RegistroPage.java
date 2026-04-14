package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {

    public static final Target FIRST_NAME = Target.the("first name")
            .located(By.id("input-firstname"));

    public static final Target LAST_NAME = Target.the("last name")
            .located(By.id("input-lastname"));

    public static final Target EMAIL = Target.the("email")
            .located(By.id("input-email"));

    public static final Target PHONE = Target.the("phone")
            .located(By.id("input-telephone"));

    public static final Target PASSWORD = Target.the("password")
            .located(By.id("input-password"));

    public static final Target CONFIRM_PASSWORD = Target.the("confirm password")
            .located(By.id("input-confirm"));

    public static final Target PRIVACY_POLICY = Target.the("privacy policy")
            .located(By.name("agree"));

    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .located(By.xpath("//input[@value='Continue']"));
}
