package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target EMAIL = Target.the("email")
            .located(By.id("input-email"));

    public static final Target PASSWORD = Target.the("password")
            .located(By.id("input-password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//input[@value='Login']"));

    public static final Target MESSAGE_ERROR = Target.the("error message")
            .located(By.cssSelector(".alert-danger"));

    public static final Target HEADER_NAME = Target.the("header name")
            .located(By.xpath("//a[contains(text(),'My Account')]"));
}
