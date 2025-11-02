package ar.unahur.edu.obj2.patroncommand.comandos;

import ar.unahur.edu.obj2.patroncommand.interfaces.Operable;
import ar.unahur.edu.obj2.patroncommand.interfaces.Programable;

public abstract class Comando implements Operable {
    Programable microPrevio;

    @Override
    public abstract void doExecute(Programable micro);

    @Override
    public void execute(Programable micro) {
       microPrevio = micro.copiar();
       micro.incProgramCounter();
       doExecute(micro);
    }
    public void undo(Programable micro){
        micro.copiarDesde(microPrevio);
    }
}