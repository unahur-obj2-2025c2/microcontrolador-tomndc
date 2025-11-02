package ar.unahur.edu.obj2.patroncommand.invoker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class ProgramaTest {

    private Programa p = new Programa();
    private Programable micro = new Microcontrolador();

    @BeforeEach
    void setUp(){
        p.vaciarLista();
        micro.reset();
    }

    @Test
    void hacerAvanzar3PosicionesElProgramCounter(){
        Integer cantidadDePosiciones = 3; 
        for (int i = 0; i < cantidadDePosiciones; i++) {
            p.agregarOperacionNop();
        }

        p.run(micro);

        assertEquals(cantidadDePosiciones, micro.getProgramCounter());
    }

    @Test 
    void sumar20Mas17(){
        p.agregarOperacionLodv(20);
        p.agregarOperacionSwap();
        p.agregarOperacionLodv(17);
        p.agregarOperacionAdd();

        p.run(micro);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter()); 
    } 

    @Test 
    void sumar2Mas8Mas5(){
        p.agregarOperacionLodv(2);
        p.agregarOperacionStr(0);
        p.agregarOperacionLodv(8);
        p.agregarOperacionSwap();
        p.agregarOperacionLodv(5);
        p.agregarOperacionAdd();
        p.agregarOperacionSwap();
        p.agregarOperacionLod(0);
        p.agregarOperacionAdd();

        p.run(micro);

        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }
}
