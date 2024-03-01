package com.networkprogramming.day1;

import java.io.IOException;
import java.net.InetAddress;

public class Main {
	public static void main(String[] args) throws IOException {

		InetAddress ocsaly = InetAddress.getByName("www.ocsaly.com");

		System.out.println("Host Address: " + ocsaly.getHostAddress());
		System.out.println("Cononcial Host Name: " + ocsaly.getCanonicalHostName());
		System.out.println("Host name : " + ocsaly.getHostName());
		ocsaly.isReachable(1000);

	}
}
