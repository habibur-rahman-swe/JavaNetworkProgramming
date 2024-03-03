package com.networkprogramming.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {
	
	// How udp works
	
	public static void main(String[] args) throws IOException {
		
		// STEP 1 create a datagram socket object
		DatagramSocket datagramSocket = new DatagramSocket(2082);
		// STEP 2 create a buffer for incoming datagram
		byte[] buffer = new byte[256];
		// STEP 3 create a datagramPacket for the incoming datagrams
		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
		// STEP 4 Accept an incoming datagram
		datagramSocket.receive(datagramPacket);
		// STEP 5 Accept the sender's address and port from the packet
		InetAddress clientAddress = datagramSocket.getInetAddress();
		// STEP 6 Retrieve the data from the packet
		String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
		// STEP 7 Create the response datagram
		DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(), clientAddress, datagramPacket.getPort());
		// STEP 8 Send the response datagram
		datagramSocket.send(outPacket);
		// STEP 9 Close the DatagramSocket
		datagramSocket.close();
	}
}
