package ejercicio.pkg1;

import java.io.Serializable;

public class Oracion implements Serializable{

    private String oracion;
    
    public Oracion(){}

    public Oracion(String oracion) {
        this.oracion = oracion;
    }

    public String getOracion() {
        return oracion;
    }

    public void setOracion(String oracion) {
        this.oracion = oracion;
    }
    
}
