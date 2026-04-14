package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import edu.pe.cibertec.tasks.RegistrarseComo;
import io.cucumber.java.Before;

public class RegistroStepDefinitions {

    Actor actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");
    }

    @Given("the user navigates to the register page")
    public void navegarRegistro() {
        actor.attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void llenarFormulario(String nombre, String apellido, String email, String telefono, String password) {
        actor.attemptsTo(
                RegistrarseComo.conDatos(nombre, apellido, email, telefono, password)
        );
    }

    @And("accepts the privacy policy")
    public void aceptarPolitica() {

    }

    @And("clicks on continue")
    public void clickContinue() {

    }

    @Then("the user should see the success message {string}")
    public void validarMensaje(String mensaje) {
        System.out.println("Validando mensaje: " + mensaje);
    }
}
