///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package udp;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//
///**
// *
// * @author alma_
// */
//public class Server {
//    public static void main(String[] args) throws SocketException, IOException {
//        DatagramSocket server=new DatagramSocket(9876);
//        byte[] receiveData= new byte[1024];
//        byte[] sendData= new byte[1024];
//        while(true){
//                DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
//                server.receive(receivePacket);
//                String sentencia= new String(receivePacket.getData());
//                System.out.println("Recibido:"+sentencia);
//                InetAddress ipaddress= receivePacket.getAddress();
//                int port= receivePacket.getPort();
//                String z= sentencia.toUpperCase();
//                sendData=z.getBytes();
//                DatagramPacket sendPacket= new DatagramPacket(sendData,sendData.length,ipaddress,port);
//                server.send(sendPacket);
//        } 
//    } 
//}
