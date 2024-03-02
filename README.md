# Java Network Programming

## Day 1
-  Getting ip Addresses from domain address
  ```
  InetAddress ocsaly = InetAddress.getByName("www.ocsaly.com");
  ```
-	Accessing `Website` codes using `BufferedReader`
	```
		URL url = new URL("https://ocsaly.com");
		URLConnection myUrlConnection = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(myUrlConnection.getInputStream()));
		String myLine;
		
		while ((myLine = br.readLine()) != null) {
			System.out.println(myLine);
		}
		
		br.close();
	```
	
-	Downloading `Website HTML` with `Buffer` and `Channel`
	```
	try {
		
		URL url = new URL("https://ocsaly.com");
		URLConnection urlConnection = url.openConnection();
		
		
		InputStream inputStream = urlConnection.getInputStream();
		ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
		
		ByteBuffer buffer = ByteBuffer.allocate(64);
		
		String line = null;
		
		while (readableByteChannel.read(buffer) > 0) {
			System.out.println(new String(buffer.array()));
			buffer.clear();
		}
		
		readableByteChannel.close();
		
	} catch(Exception e) {
		System.out.println(e.getMessage());
	}
	```
	
	
	
## Day 2
-	Printing network adapters
```
	try {
		Enumeration<NetworkInterface> networkIe = NetworkInterface.getNetworkInterfaces();
		System.out.println("Network Display: \n");
		for (NetworkInterface element : Collections.list(networkIe)) {
			System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
```