/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author alma_
 */
public class Client {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        System.out.println("Ejecutando cliente...");
        Thread hilo = new Thread(() ->{
            try(
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                DatagramSocket client = new DatagramSocket();
            ){
                while(true){
                    InetAddress ipadress = InetAddress.getByName("localhost");
                    /*paquete de datos para enviar*/
                    byte[] sendData = new byte[1024];
                    /*paquete de datos para recibir*/
                    byte[] receiveData = new byte[1024];
                    
                    int port = 8080;
                    
                    String sentence = inFromUser.readLine();
                    
                    if(sentence.equals("adios")){
                        break;
                    }
                    
                    sendData = sentence.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipadress, 9876);
                    client.send(sendPacket);
                    
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    client.receive(receivePacket);
                    String recibir = new String(receivePacket.getData());
                    System.out.println("Servidor: " + recibir);
                }
            
            }catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
                
        });
        hilo.start();
    }
}
    
