package com.masteringhttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) {
		if (args.length < 1) return;
		
		URL url = null;
		
		try {
			url = new URL("google.com");
		} catch (MalformedURLException e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		String hostname = url.getHost();
		
		int port = 80;
		
		try (Socket socket = new Socket(hostname, port)) {
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			
			writer.println("HOST: " + hostname);
			writer.println("HEAD : " + url.getPath() + "HTTP//1.1");
			writer.println("USER AGENT : simple user agent");
			writer.println("Accept : text/html");
			writer.println("Connection : Close");
			
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (UnknownHostException unknownHostException) {
			System.out.println("UnknownHotException : " + unknownHostException.getMessage());
		} catch (IOException ioException) {
			System.out.println("IOException: " + ioException.getMessage());
		}
	}
}
