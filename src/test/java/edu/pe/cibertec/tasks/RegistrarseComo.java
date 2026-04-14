package edu.pe.cibertec.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import edu.pe.cibertec.ui.RegistroPage;

public class RegistrarseComo implements  Task{

    private String nombre, apellido, email, telefono, password;

    public RegistrarseComo(String nombre, String apellido, String email, String telefono, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public static RegistrarseComo conDatos(String nombre, String apellido, String email, String telefono, String password) {
        return Tasks.instrumented(RegistrarseComo.class, nombre, apellido, email, telefono, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(RegistroPage.FIRST_NAME),
                Enter.theValue(apellido).into(RegistroPage.LAST_NAME),
                Enter.theValue(email).into(RegistroPage.EMAIL),
                Enter.theValue(telefono).into(RegistroPage.PHONE),
                Enter.theValue(password).into(RegistroPage.PASSWORD),
                Enter.theValue(password).into(RegistroPage.CONFIRM_PASSWORD),
                Click.on(RegistroPage.PRIVACY_POLICY),
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }
}
