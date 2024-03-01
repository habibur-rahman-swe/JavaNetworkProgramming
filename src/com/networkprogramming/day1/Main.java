package com.networkprogramming.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class Main {
	public static void main(String[] args) throws IOException {

		InetAddress ocsaly = InetAddress.getByName("www.ocsaly.com");

		
		try {
			
			URL url = new URL("https://ocsaly.com");
			URLConnection myUrlConnection = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(myUrlConnection.getInputStream()));
			String myLine;
			
			while ((myLine = br.readLine()) != null) {
				System.out.println(myLine);
			}
			
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}

	}
}
