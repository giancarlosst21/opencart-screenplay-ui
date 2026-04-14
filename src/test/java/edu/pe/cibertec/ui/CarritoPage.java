package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

    public static final Target PRODUCTO_LINK = Target.the("producto link")
            .locatedBy("//a[text()='{0}']");

    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
            .located(By.id("button-cart"));

    public static final Target CART_BUTTON = Target.the("cart button")
            .located(By.id("cart-total"));

    public static final Target VIEW_CART = Target.the("view cart")
            .located(By.xpath("//strong[text()='View Cart']"));

    public static final Target PRODUCT_NAME_CART = Target.the("product in cart")
            .located(By.xpath("//td[@class='text-left']/a"));
}
