package ar.unahur.edu.obj2.patroncommand.excepciones;

public class fueraDeRangoExcepcion extends RuntimeException {
    public fueraDeRangoExcepcion(String string) {
        super(string);
    }
}
