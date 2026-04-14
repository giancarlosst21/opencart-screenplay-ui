package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ResultadosDeBusqueda implements Question<Boolean> {

    private String producto;

    public ResultadosDeBusqueda(String producto) {
        this.producto = producto;
    }

    public static ResultadosDeBusqueda contiene(String producto) {
        return new ResultadosDeBusqueda(producto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<String> productos = BusquedaPage.PRODUCT_TITLES
                .resolveAllFor(actor)
                .texts();

        return productos.stream()
                .anyMatch(p -> p.contains(producto));
    }
}
