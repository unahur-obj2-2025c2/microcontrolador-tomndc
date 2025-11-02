package ar.unahur.edu.obj2.patroncommand.excepciones;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.invoker.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class FueraDelEspacioDeMemoriaExceptionTest {

    private Programa p = new Programa();
    private Programable micro = new Microcontrolador();

    @Test
    void validarExcepcionDireccionEnMemoriaInferior(){
        p.agregarOperacionStr(-15);
        assertThrows(FueraDelEspacioDeMemoriaException.class,
        () -> {p.run(micro);});
    }

    @Test
    void validarExcepcionDireccionEnMemoriaSuperior(){
        p.agregarOperacionStr(1500);
        assertThrows(FueraDelEspacioDeMemoriaException.class,
        () -> {p.run(micro);});
    }
}
