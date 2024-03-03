package com.networkprogramming.day2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws URISyntaxException, IOException {
//
//		String website = "https://netty.io/index.html";
//
//		URI webURI = new URI("https", "udemy.com", "/course/network-programming-java-mastering-java-networking",
//				"Java Network Programming - Mastering TCP/IP : CJNP+ 2024 JVA");
//
//		getURI(webURI);

//		String web = "https://en.wikipedia.org/wiki/URL#Citations";
//		URL url = new URL(web);
//		getURL(url);

		String url = "google.com";
		
		printInetAddress(url);
		
	}

	static void printInetAddress(String url) throws IOException {
//		InetAddress names[] = InetAddress.getAllByName(url);
//
//		for (InetAddress name : names) {
//			System.out.println(name);
//		}
		
		InetAddress myAddress = InetAddress.getByName(url);
		System.out.println(myAddress.getAddress().getClass());
		System.out.println(myAddress.isLoopbackAddress());
		
	}

	static void getURL(URL url) {
		System.out.println("HOST: " + url.getHost());
		System.out.println("PATH: " + url.getPath());
		System.out.println("REF:  " + url.getRef());
		System.out.print("Port: " + url.getPort());
	}

	static void getURI(URI myUri) {
		System.out.println(myUri.getAuthority());
		System.out.println(myUri.getPath());
		System.out.println(myUri.getHost());
		System.out.println(myUri.getPort());
		System.out.println(myUri.getScheme());
		System.out.println(myUri.getQuery());
	}

}
