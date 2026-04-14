package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.ContadorDelCarrito;
import edu.pe.cibertec.tasks.AgregarAlCarrito;
import edu.pe.cibertec.ui.CarritoPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CarritoStepDefinitions {

    private Actor actor;

    @When("the user adds the product {string} to the cart")
    public void agregarProducto(String producto) {
        actor.attemptsTo(
                AgregarAlCarrito.conNombre(producto)
        );
    }

    @Then("the cart should show {string}")
    public void validarCarrito(String cantidad) {
        actor.should(
                seeThat(ContadorDelCarrito.valor(), containsString(cantidad))
        );
    }

    @And("navigates to the cart")
    public void irAlCarrito() {
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Click.on(CarritoPage.CART_BUTTON),
                net.serenitybdd.screenplay.actions.Click.on(CarritoPage.VIEW_CART)
        );
    }

    @Then("the user should see the product {string} in the cart list")
    public void validarProductoEnCarrito(String producto) {
        actor.should(
                seeThat(
                        net.serenitybdd.screenplay.questions.Text.of(CarritoPage.PRODUCT_NAME_CART),
                        containsString(producto)
                )
        );
    }
}
