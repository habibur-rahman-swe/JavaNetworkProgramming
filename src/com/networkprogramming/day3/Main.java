package com.networkprogramming.day3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(1092); // 1. port number
		
		
		Socket link = serverSocket.accept(); // 2
		
		
		Scanner input = new Scanner(link.getInputStream()); // 3
		PrintWriter output = new PrintWriter(link.getOutputStream());
		
		output.println("Awating for data....."); // 4
		String myInput = input.nextLine(); // 4
		
		link.close(); // step 5
		
	}
}
