package com.networkprogramming.tcpudp;

public class Main {
	public static void main(String[] args) {
		// myserver.com/image.zip
		String fileURL = "E:/Downloads/Digital Image Processing-20240209T052438Z-001";
		String saveDir = "C:/Users/Habibur Rahman/Pictures/Camera Roll/";
		
		try {
			HttpDownloader.downloadFile(fileURL, saveDir);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
