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

public class Frase implements Serializable{

    private String frase;
    
    public Frase(){}

    public Frase(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
}
