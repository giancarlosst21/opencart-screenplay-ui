package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.CarritoPage;
import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito  implements Task {

    private String producto;

    public AgregarAlCarrito(String producto) {
        this.producto = producto;
    }

    public static AgregarAlCarrito conNombre(String producto) {
        return instrumented(AgregarAlCarrito.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_INPUT),
                Click.on(BusquedaPage.SEARCH_BUTTON),

                Click.on(CarritoPage.PRODUCTO_LINK.of(producto)),

                Click.on(CarritoPage.ADD_TO_CART_BUTTON)
        );
    }
}
