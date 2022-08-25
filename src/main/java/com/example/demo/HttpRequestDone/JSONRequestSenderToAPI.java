package com.example.demo.HttpRequestDone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.demo.HttpRequestDone.Methods.CallingMethods;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test {

	public static void sendRequestToAPI() throws IOException {

//		System.out.println(url.toString());
		URL url = null;

		try {
			url = new URL("https://reqres.in/api/users");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		Student student = new Student("sagar", "Programmer", 98121, "Delhi");
		CallingMethods cm = new CallingMethods();
		cm.methodURL(url,student);

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