package edu.pe.cibertec.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import edu.pe.cibertec.ui.LoginPage;

public class IniciarSesionComo implements Task {

    private String email, password;

    public IniciarSesionComo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static IniciarSesionComo conCredenciales(String email, String password) {
        return Tasks.instrumented(IniciarSesionComo.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPage.EMAIL),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
