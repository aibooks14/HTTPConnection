package com.example.demo.HttpRequestDone;

import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionTest {
	public static void main(String args[]) throws Exception {
		URL url = new URL("http://google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int code = connection.getResponseCode();
		System.out.println("Response code of the object is " + code);
		if (code == 200) {
			System.out.println("OK");
		}
	}
}