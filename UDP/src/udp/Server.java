/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author alma_
 */
public class Server {

    public static void main(String[] args) throws SocketException, IOException {
        System.out.println("Ejecutando servidor ...");
        
            Thread hilo = new Thread(() ->{
                try(
                    DatagramSocket server = new DatagramSocket(9876);
                    BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
                ){
                    
                    
                    
                    while (true) {
                        byte[] sendData = new byte[1024];
                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        server.receive(receivePacket);
                        
                        int len = receivePacket.getLength();
                        String str = new String(receiveData,0,len);
                        
                        System.out.println(str);
                        
                        
                        int puerto = receivePacket.getPort();
                        
//                        String keyboardInputString = keyboardIn.readLine();
                        
                        String sentencia = keyboardIn.readLine();

                        InetAddress ipaddress = receivePacket.getAddress();
                        int port = receivePacket.getPort();
                        
                        sendData = sentencia.getBytes();
                        receivePacket = new DatagramPacket(sendData, sendData.length, ipaddress, port);
                        server.send(receivePacket);
                        
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
