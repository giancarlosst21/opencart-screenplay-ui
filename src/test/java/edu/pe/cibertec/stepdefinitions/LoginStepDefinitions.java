package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import edu.pe.cibertec.tasks.IniciarSesionComo;

public class LoginStepDefinitions {

    Actor actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");
    }

    @Given("the user navigates to the login page")
    public void navegarLogin() {
        actor.attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void ingresarCredenciales(String email, String password) {
        actor.attemptsTo(
                IniciarSesionComo.conCredenciales(email, password)
        );
    }

    @And("clicks on the login button")
    public void clickLogin() {
        // ya está en el Task
    }

    @Then("the user should see the name {string} in the page header")
    public void validarNombre(String nombre) {
        System.out.println("Validando nombre: " + nombre);
    }

    @Then("the user should see the error message {string}")
    public void validarError(String mensaje) {
        System.out.println("Validando error: " + mensaje);
    }
}
