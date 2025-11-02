package ar.unahur.edu.obj2.patroncommand.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;

public class Programa {

    List<Operable> operaciones;

    public Programa() {
        operaciones = new ArrayList<>();
    }

    public void agregarOperacionNop(){
        operaciones.add(new Nop());
    }

    public void agregarOperacionAdd(){
        operaciones.add(new Add());
    }

    public void agregarOperacionSwap(){
        operaciones.add(new Swap());
    }

    public void agregarOperacionLod(Integer direccionEnMemoria){
        operaciones.add(new Lod(direccionEnMemoria));
    }

    public void agregarOperacionStr(Integer direccionEnMemoria){
        operaciones.add(new Str(direccionEnMemoria));
    }

    public void agregarOperacionLodv(Integer valor){
        operaciones.add(new Lodv(valor));
    }

    public void vaciarLista(){
        operaciones.clear();
    }

    public void run(Programable micro){
        micro.run(operaciones);
    }

}
