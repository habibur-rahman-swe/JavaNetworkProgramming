package com.networkprogramming.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	
	private static final int PORT = 2082;
	private static DatagramSocket datagramSocket;
	private static DatagramPacket inPacket, outPacket;
	private static byte[] buffer;
	
	public static void main(String[] args) {
		System.out.println("Opening port...\n");
		try {
			datagramSocket = new DatagramSocket(PORT); // STEP 1
		} catch (SocketException socketException) {
			System.out.println("Unable to open port");
			System.out.println(socketException.getMessage());
			System.exit(1);
		}
		handleClient();
	}
	
	
	public static void handleClient() {
		try {
			String messageIn, messageOut;
			int numMessages = 0;
			InetAddress clientAddress = null;
			int clientPort;
			
			do {
				buffer = new byte[256]; // STEP 2
				inPacket = new DatagramPacket(buffer, buffer.length); // STEP 3
				datagramSocket.receive(inPacket); // STEP 4
				
				clientAddress = inPacket.getAddress(); // STEP 5
				clientPort = inPacket.getPort();
				
				messageIn = new String(inPacket.getData(), 0, inPacket.getLength()); // STEP 6
				System.out.println("Message Received");
				
				numMessages++;
				messageOut = "Message " + numMessages + " : " + messageIn;
				
				outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress, clientPort); // STEP 7
				datagramSocket.send(outPacket); // STEP 8
				
			} while (true);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			System.out.println("\n*Closing the connection*");
		}
	}
}
