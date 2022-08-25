package com.example.demo.HttpRequestDone.Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.demo.HttpRequestDone.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CallingMethods {
	public void methodURL(URL url, Student student) throws IOException {

		HttpURLConnection con;
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonInputString = studentObjectJson(student);

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

		int statusCode = con.getResponseCode();
		System.out.println("Status-Code is after response " + statusCode);

	}

	public String studentObjectJson(Student student) {

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonInputString = null;
		try {
			jsonInputString = objectMapper.writeValueAsString(student);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonInputString);
		return jsonInputString;
	}

}
