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
// Final de recepción (servidor)
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
    // Crea un objeto Socket que debe cerrarse
    DatagramSocket ds = null;
    // Manejar la excepción después de la inicialización
        try {
            ds = new DatagramSocket(10000);
            // Crea una matriz de bytes
            byte[] bs =new byte[1024];
                     // Crear paquete de datos
            DatagramPacket dp = new DatagramPacket(bs,bs.length);
                     System.out.println ("Se ha iniciado el servidor UDP ...");
            while (true){
                             //Recibir datos 
                ds.receive(dp);
                             // Una barra roja indica una excepción, quite el conector de abajo (captura (SocketException e)), no habrá barra roja
                             // Obtener la IP del cliente
                InetAddress inetAddress = dp.getAddress();
                             //obtener datos 
                byte[] data = dp.getData();
                             // Obtener la longitud de los datos transmitidos
                int length = dp.getLength();
                             // se convierte en una cadena
                String str = new String(bs,0,length);
                             System.out.println (inetAddress.getHostAddress () + "Datos enviados:" + str);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                     // ds no está vacío para cerrar
            if (ds != null){
                ds.close();
            }

        }
    }
}