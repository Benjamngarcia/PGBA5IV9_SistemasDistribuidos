///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package udp;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//
///**
// *
// * @author alma_
// */
//public class Client {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
//       
//        BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
//        
//        DatagramSocket client=new DatagramSocket();
//       
//        InetAddress ipadress=InetAddress.getByName("localhost");
//        /*paquete de datos para enviar*/
//        
//        byte[] sendData= new byte[1024];
//        
//        /*paquete de datos para recibir*/
//        
//        byte[] receiveData= new byte[1024];
//        
//        String sentence= inFromUser.readLine();
//        
//        sendData=sentence.getBytes();
//        
//        DatagramPacket sendPacket= new DatagramPacket(sendData, sendData.length, ipadress, 9876);
//        
//        client.send(sendPacket);
//        
//         DatagramPacket receivePacket= new DatagramPacket(receiveData,receiveData.length);
//                
//        client.receive(receivePacket);
//        
//        String recibir= new String(receivePacket.getData());
//        
//        System.out.println("Servidor:"+recibir);
//        
//        client.close();      
//        
//        
//    }
//    
//}
//
