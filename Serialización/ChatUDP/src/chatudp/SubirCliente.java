/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudp;

/**
 *
 * @author bengy
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author :  Cai Zhengjie
 * @email :caizhengjie888@icloud.com
 * @date : 2020/2/20
 * @time :  4:31 pm
 */
 //Cliente
public class SubirCliente {
    public static void main(String[] args) {
        System.out.println("El cliente se está ejecutando ...");
        try(
                                 // Cree un objeto DatagrameSocket y asigne puertos que pueda usar el sistema
                DatagramSocket socket = new DatagramSocket();
                FileInputStream fin = new FileInputStream("/Users/caizhengjie/Desktop/qq/123.txt");
                BufferedInputStream in = new BufferedInputStream(fin);
                ){
 // Crear un objeto de dirección IP de host remoto
            InetAddress address = InetAddress.getByName("localhost");
 // preparar un búfer
            byte[] buffer = new byte[1024];
 // Leer datos del flujo de archivos por primera vez
            int len = in.read(buffer);
            while (len != -1){
 // Crear objeto de paquete de datagrama
                DatagramPacket packet = new DatagramPacket(buffer,len,address,8080);
 // enviar paquete de datagramas
                socket.send(packet);
 // Lee los datos del archivo nuevamente
                len = in.read(buffer);
            }
 // Crear objeto de paquete de datagrama
            DatagramPacket packet = new DatagramPacket("bye".getBytes(),3,address,8080);
 // Enviar marca final
            socket.send(packet);
            System.out.println("carga completada");
        } catch (SocketException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

