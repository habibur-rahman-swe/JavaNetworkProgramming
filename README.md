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