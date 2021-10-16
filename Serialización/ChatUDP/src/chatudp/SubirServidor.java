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
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author :  Cai Zhengjie
 * @email :caizhengjie888@icloud.com
 * @date : 2020/2/20
 * @time :  3:56 pm
 */
 // Terminal de servicio
public class SubirServidor {
    public static void main(String[] args) {
        System.out.println("Ejecutar en el lado del servidor ...");
 // Crear un hilo secundario
        Thread thread = new Thread(() ->{
            try (
 // Crear objeto DatagrameSocket, especificar puerto 8080
                    DatagramSocket socket = new DatagramSocket(8080);
 // Cree una secuencia de salida de archivo y cree una secuencia de salida almacenada en búfer
                    FileOutputStream fout = new FileOutputStream("/Users/caizhengjie/Desktop/qq/e/56.txt");
                    BufferedOutputStream out = new BufferedOutputStream(fout);
                    ){
 // preparar un búfer
                byte[] buffer = new byte[1024];

 // Acepta cíclicamente paquetes de datagramas
                while (true){
 // Crear un objeto de paquete de datagrama para recibir datos
                    DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
 // Recibir paquetes
                    socket.receive(packet);
 // Recibir longitud de datos
                    int len = packet.getLength();
                    if(len == 3){
 // obtener la marca final
                        String flag = new String(buffer,0,3);
 // Juzgue la bandera de fin, si es un adiós, luego finalice la recepción
                        if (flag.equals("bye")){
                            break;
                        }
                    }
 //                    Entrada de datos 
                    out.write(buffer,0,3);
                }
                System.out.println("¡Recepción completada!");
            } catch (SocketException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
 // Inicia el hilo
        thread.start();
    }
}

