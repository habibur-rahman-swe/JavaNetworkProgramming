package com.networkprogramming.day2;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

public class Main {

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> networkIe = NetworkInterface.getNetworkInterfaces();
			System.out.println("Network Display: \n");
			for (NetworkInterface element : Collections.list(networkIe)) {
				System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
