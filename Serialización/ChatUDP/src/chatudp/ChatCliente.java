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
 * @author : Cai Zhengjie
 * @email :caizhengjie888@icloud.com
 * @date : 2020/2/20
 * @time :  8:25 pm
 */
 //Cliente
public class ChatCliente {
    public static void main(String[] args) {
        System.out.println("El cliente se está ejecutando ...");
 // Crear un hilo secundario
        Thread thread = new Thread(() ->{
            try (
//                                        Cree un objeto DatagrameSocket, y el sistema asigna puertos automáticamente
                    DatagramSocket socket = new DatagramSocket();
                    BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
            ){
                while (true){
 //              enviar datos 
 // preparar un búfer
                    byte[] buffer = new byte[128];
 // Dirección IP del servidor
                    InetAddress address = InetAddress.getByName("localhost");
 // Número de puerto del servidor
                    int port = 8080;
 // Lee el número de puerto ingresado por el teclado
                    String keyboardInputString = keyboardIn.readLine();
 // Salga del bucle y finalice el hilo
                    if (keyboardInputString.equals("bye")){
                        break;
                    }
 // Leer la matriz de bytes de entrada del teclado
                    byte[] b = keyboardInputString.getBytes();
                                         // Crear un objeto DatagramPacket para enviar datos desde el cliente
                     DatagramPacket packet = new DatagramPacket(b,b.length,address,port);
 // enviar
                    socket.send(packet);

 // Recibir datagrama
                    packet = new DatagramPacket(buffer,buffer.length);
                    socket.receive(packet);

 // Aceptar longitud de datos
                    int len = packet.getLength();
                    String variablestring  = new String(buffer,0,len);
 // imprimir datos recibidos
                    System.out.println(variablestring);
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

