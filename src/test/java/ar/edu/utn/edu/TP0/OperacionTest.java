package ar.edu.utn.edu.TP0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperacionTest {

    Operacion operacion;
    Item item1;
    Item item2;
    Item item3;

    @BeforeEach
    void setUp() {
        operacion = new Operacion();
        item1 = new Item(Tipo.Artículo, "Remera", 500);
        item2 = new Item(Tipo.Artículo, "Televisor", 30000);
        item3 = new Item(Tipo.Servicio, "Taxi", 350);
    }

    @Test
    public void testPrecioCorrecto() {
        operacion.agregarItem(item1);
        operacion.agregarItem(item2);
        operacion.cerrar();
        item1.setValor(700);
        operacion.generarRemito().imprmimirRemito();
        assertEquals(30500 ,operacion.calcularValor(),"El precio no es el que corrrespondía al momento de cerrar la operación");
    }

    @Test
    public void testFallaRemitoConServicio() {
        operacion.agregarItem(item1);
        operacion.agregarItem(item3);
        assertThrows( RuntimeException.class, ()-> operacion.generarRemito(), "El remito no se puede generar si hay servicios");
    }
}