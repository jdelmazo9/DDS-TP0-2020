package ar.edu.utn.dds.auto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {

    @Test
    public void testEncendidoOK() {
        //Precondicion
        Auto auto = new Auto();

        //Op/acc

        auto.encender();

        //Res/Postcond
        String message = "El auto debería estar encendido";
        assertTrue(auto.isPrendido(),message);
    }
}


