package ar.unahur.edu.obj2.patroncommand.modelos;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.excepciones.fueraDeRangoExcepcion;
import ar.unahur.edu.obj2.patroncommand.interfaces.Operable;
import ar.unahur.edu.obj2.patroncommand.interfaces.Programable;

public class Microcontrolador implements Programable {
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o->o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        this.programCounter += 1;
    }

    @Override
    public Integer getProgramCounter() {
        return this.programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return this.acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return this.acumuladorB;
    }
    private void estaEnRango(Integer direccionEnMemoria) {
        if (direccionEnMemoria >= memoria.size() || direccionEnMemoria < 0) {
            throw new fueraDeRangoExcepcion("direccion incorrecta");
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
        return this.memoria.get(addr);
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
        this.programCounter = programable.getProgramCounter();
        this.acumuladorA = programable.getAcumuladorA();
        this.acumuladorB = programable.getAcumuladorB();
    }
    
}