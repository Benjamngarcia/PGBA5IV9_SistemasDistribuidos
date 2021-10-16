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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author :  Cai Zhengjie
 * @email :caizhengjie888@icloud.com
 * @date : 2020/2/20
 * @time :  7:57 pm
 */
 // Terminal de servicio
public class ChatServidor {
    public static void main(String[] args) {
        System.out.println("Ejecutar en el lado del servidor ...");
 // Crear un hilo secundario
        Thread thread = new Thread(() ->{
            try (
//                                        Crear objeto DatagrameSocket, especificar puerto8080
                    DatagramSocket socket = new DatagramSocket(8080);
                    BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
                    ){
                while (true){
 // Recibir datagrama
 // preparar un búfer
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                    socket.receive(packet);
 // Recibir longitud de datos
                    int len = packet.getLength();
                    String variablestring = new String(buffer,0,len);
 // Imprime los datos recibidos
//                    System.out.printf("Datos recibidos del cliente: [% s] \ n",str);
                      System.out.println(variablestring);

 //                    enviar datos 
 // Obtener la dirección del cliente del paquete de datos del cliente
                    InetAddress address = packet.getAddress();
 // Obtenga el número de puerto del cliente del paquete de datos del cliente
                    int port = packet.getPort();

 // Lee la cadena ingresada por el teclado
                    String keyboardInputString = keyboardIn.readLine();
 // Lee la matriz de bytes del teclado
                    byte[] b = keyboardInputString.getBytes();
 // Crear un objeto DatagramPacket para enviar datos desde el cliente
                    packet = new DatagramPacket(b,b.length,address,port);
 // Enviar datos al cliente
                    socket.send(packet);
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
 // Inicia el hilo
        thread.start();
    }
}
