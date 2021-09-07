/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertircadena;

/**
 *
 * @author bengy
 */
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
