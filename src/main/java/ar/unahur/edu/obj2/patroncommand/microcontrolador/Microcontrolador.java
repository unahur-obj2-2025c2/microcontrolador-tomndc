package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.excepciones.FueraDelEspacioDeMemoriaException;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable {

    private Integer acumuladorA = 0; // acumulador A
    private Integer acumuladorB = 0; // acumulador B
    private Integer programCounter = 0; // program counter
    private List<Integer> memoria = Arrays.asList(new Integer[1024]); // area de 1024 valores enteros

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        programCounter += 1;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    private void estaEnRango(Integer direccionEnMemoria) {
        if (direccionEnMemoria >= memoria.size() || direccionEnMemoria < 0) {
            throw new FueraDelEspacioDeMemoriaException("La dirección de memoria ingresada está fuera de los límites.");
        }
    }

    @Override
    public void setAddr(Integer addr) {
        estaEnRango(addr);
        memoria.set(addr, acumuladorA);
    }

    @Override
    public Integer getAddr(Integer addr) {
        estaEnRango(addr);
        return memoria.get(addr);
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        memoria = Arrays.asList(new Integer[1024]);
    }

    @Override
    public Programable copiar() {
        Microcontrolador nuevo = new Microcontrolador();
        nuevo.acumuladorA = this.acumuladorA;
        nuevo.acumuladorB = this.acumuladorB;
        nuevo.programCounter = this.programCounter;
        return nuevo;
    }

    @Override
    public void copiarDesde(Programable programable) {
        programCounter = programable.getProgramCounter();
        acumuladorA = programable.getAcumuladorA();
        acumuladorB = programable.getAcumuladorB();
    }

}
