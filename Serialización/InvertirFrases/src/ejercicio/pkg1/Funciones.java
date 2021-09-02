package ejercicio.pkg1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.*;

public class Funciones {

    private File archivo = new File("Datos.dat");
    private static ObjectInputStream entrada;
    private static ObjectOutputStream salida;
    ArrayList<Oracion> listaOraciones = new ArrayList();

    public void Invertir(String oracion) throws IOException {

        String oracionInvertida = "";

        if (oracion.length() <= 0) {
            JOptionPane.showMessageDialog(null, "No puede invertir si no pones nada, dah", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {

            for (int i = oracion.length() - 1; i >= 0; i--) {

                char car = oracion.charAt(i);
                oracionInvertida = oracionInvertida + car;

            }

            JOptionPane.showMessageDialog(null, "La frase que invertiste es: \n" + oracionInvertida);
            agregarOracion(oracionInvertida);
            
        }

    }

    public void agregarOracion(String oracion) throws IOException {

        Oracion ora = new Oracion(oracion);
        listaOraciones.add(ora);
        Guardar();
        JOptionPane.showMessageDialog(null, "La frase ha sido guardada");

    }

    public void Guardar() throws FileNotFoundException, IOException {

        ObjectOutputStream salida;
        FileOutputStream fo = new FileOutputStream(archivo);
        salida = new ObjectOutputStream(fo);
        salida.writeObject(listaOraciones);

        salida.close();

    }

    public void Leer() throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream fi = new FileInputStream(archivo);
        ObjectInputStream entrada = new ObjectInputStream(fi);

        listaOraciones = (ArrayList) entrada.readObject();

        int caso = 0;

        for (Oracion p : listaOraciones) {

            caso++;
            JOptionPane.showMessageDialog(null, " \n"
                    + "Case #" + caso + ": \n"
                    + p.getOracion());

        }

    }

}
