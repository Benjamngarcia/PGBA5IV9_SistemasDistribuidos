package Calculadora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Funciones {

    private File archivo = new File("Datos.dat");
    private static ObjectInputStream entrada;
    private static ObjectOutputStream salida;
    ArrayList<Numeros> listaOperaciones = new ArrayList();
    
    public void agregarOraciones(float num1, float num2, float resultado, String op) throws IOException{
        Numeros n = new Numeros(num1, num2, resultado, op);
        listaOperaciones.add(n);
        Guardar();
    }
    
    public void Guardar() throws FileNotFoundException, IOException{
        
        ObjectOutputStream salida;
        FileOutputStream fo = new FileOutputStream(archivo);
        salida = new ObjectOutputStream(fo);
        salida.writeObject(listaOperaciones);
        salida.close();
        
    }
    
    public void Leer() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        FileInputStream fi = new FileInputStream(archivo);
        ObjectInputStream entrada = new ObjectInputStream(fi);
        listaOperaciones = (ArrayList)entrada.readObject();
        
        for(Numeros nums : listaOperaciones){
            JOptionPane.showMessageDialog(null, nums.getNum1() + nums.getOperacion() + nums.getNum2() + " = " + nums.getResp() );
        }
        
    }
    
}
