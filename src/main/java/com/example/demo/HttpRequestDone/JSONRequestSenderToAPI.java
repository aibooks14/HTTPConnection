package com.example.demo.HttpRequestDone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test {

	public static void sendRequestToAPI() throws IOException {

		URL url = null;
		HttpURLConnection con  ;
		try {
			url = new URL("https://reqres.in/api/users");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
//		System.out.println(url.toString());
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		
		
		Student student = new Student("sagar", "Programmer", 98121, "Delhi");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonInputString = null;
		try {
			jsonInputString = objectMapper.writeValueAsString(student);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonInputString);
		
		

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
//				    System.out.println(response.toString());
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int statusCode = con.getResponseCode();
		System.out.println("Status-Code is after response " +statusCode);
		
	}

	
}

public class JSONRequestSenderToAPI {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Test.sendRequestToAPI();

		long endTime = System.currentTimeMillis();
		System.out.println("----------------------------------------");
		System.out.println("開始時刻：" + startTime + " ms");
		System.out.println("終了時刻：" + endTime + " ms");
		System.out.println("処理時間：" + (endTime - startTime) + " ms");
	}

}

//Making Json Request Using HTTP Connect
//https://www.baeldung.com/java-connect-via-proxy-server