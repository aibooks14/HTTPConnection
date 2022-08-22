package com.example.demo.HttpPackage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpRequestJson {
	
	private static final String POST_API_URL = "https://jsonplaceholder.typicode.com/posts" ;
	public static void main(String[]args) throws IOException, InterruptedException { 
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
							.GET()
							.header("accept", "application/json")
							.uri(URI.create(POST_API_URL))
							.build();
		
		HttpResponse<String> response =client.send(request, BodyHandlers.ofString()) ;
		System.out.println(response.statusCode());
//		System.out.println(response.body());
							
		
		
	}

}
