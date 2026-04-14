package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.tasks.BuscarProducto;
import edu.pe.cibertec.ui.BusquedaPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BusquedaStepDefinitions {

    private Actor actor;

    @Given("the user is on the OpenCart home page")
    public void elUsuarioEstaEnHome() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");

        actor.wasAbleTo(
                net.serenitybdd.screenplay.actions.Open.url("http://opencart.abstracta.us/")
        );
    }

    @When("the user searches for the product {string}")
    public void elUsuarioBuscaProducto(String producto) {
        actor.attemptsTo(
                BuscarProducto.conNombre(producto)
        );
    }

    @Then("the user should see at least one result with the name {string}")
    public void validaResultado(String producto) {
        actor.should(
                seeThat(ResultadosDeBusqueda.contiene(producto), is(true))
        );
    }

    @Then("the user should see the message {string}")
    public void validaMensaje(String mensajeEsperado) {
        actor.should(
                seeThat(
                        actor1 -> BusquedaPage.PRODUCT_TITLES.resolveAllFor(actor1).size(),
                        is(0)
                )
        );
    }
}
