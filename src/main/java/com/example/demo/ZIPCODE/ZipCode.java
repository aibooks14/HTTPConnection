package com.example.demo.ZIPCODE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test01 {

	public static void sendRequestToAPI() throws IOException {

		URL url = null;
		try {
			url = new URL("https://zipcloud.ibsnet.co.jp/api/search");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
//		System.out.println(url.toString());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		ZipcodeEntity z = new ZipcodeEntity(2140008);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonInputString = null;
		try {
			jsonInputString = objectMapper.writeValueAsString(z);
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
				    System.out.println(response.toString());
//			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ZipCode {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Test01.sendRequestToAPI();

		long endTime = System.currentTimeMillis();

		System.out.println("開始時刻：" + startTime + " ms");
		System.out.println("終了時刻：" + endTime + " ms");
		System.out.println("処理時間：" + (endTime - startTime) + " ms");
	}

}

//Making Json Request Using HTTP Connect
//https://www.baeldung.com/java-connect-via-proxy-server