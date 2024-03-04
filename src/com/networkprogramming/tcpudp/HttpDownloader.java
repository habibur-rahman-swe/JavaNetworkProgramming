package com.networkprogramming.tcpudp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {
	
	private static final int BUFFER_SIZE = 4096;
	
	public void downloadFile(String fileURL, String saveDir) throws IOException {
		
		URL url = new URL(fileURL);
		HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
		int responseCode = httpConn.getResponseCode();
		
		if (responseCode == HttpURLConnection.HTTP_OK) {
			String fileName = "";
			
			String disposition = httpConn.getHeaderField("Content-Disposition");
			String contentType = (String)httpConn.getContent();
			int contentLength = httpConn.getContentLength();
			
			if (disposition != null) {
				int index = disposition.indexOf("filename=");
				if (index > 0) {
					fileName = disposition.substring(index + 10, disposition.length() - 1);
				}
			} else {
				fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());
				
			}
			System.out.println("Content-Type : " + contentType);
			System.out.println("Content-Disposition : " + disposition);
			System.out.println("Content-Length : " + contentLength);
			System.out.println("File name : " + fileName);
		}
		
	}
	
}
