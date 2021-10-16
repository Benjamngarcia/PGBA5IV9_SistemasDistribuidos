/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioudp;

/**
 *
 * @author bengy
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UPDClient {
public static void main(String[] args) {
// Cree un socket UDP para el cliente
DatagramSocket ds = null;
// BufferedReader: lee y devuelve una cadena de tipo String
BufferedReader read = null;
read = new BufferedReader (new InputStreamReader (System.in)); // entrada desde la consola
            try {
        ds = new DatagramSocket();
        String line = null;
                 while ((line = read.readLine())! = null)
        {
//                         / * // Crear paquete de datos
//                   String str = "Hola a todos"; * /
            byte[] bs = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bs, bs.length,
                    InetAddress.getByName("192.168.0.100"), 10000);
                         // Enviar paquete de datos
            ds.send(dp);
        }
 
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        if (read != null){
                               // Tecla de manejo de excepciones: Ctrl + Alt + t abrir envolvente con y seleccionar la sexta
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(ds !=null){
            ds.close();
        }
    }
}
}
