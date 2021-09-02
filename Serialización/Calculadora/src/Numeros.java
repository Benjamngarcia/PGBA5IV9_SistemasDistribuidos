package Calculadora;

import java.io.Serializable;

public class Numeros implements Serializable{

    private float num1;
    private float num2;
    private float resp;
    private String operacion;
    
    public Numeros(){}
    
    public Numeros(float num1, float num2, float resp, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;
        this.resp = resp;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }   

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public float getResp() {
        return resp;
    }

    public void setResp(float resp) {
        this.resp = resp;
    }
    
    
}
