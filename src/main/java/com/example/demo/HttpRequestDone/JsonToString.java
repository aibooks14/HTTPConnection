package com.example.demo.HttpRequestDone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToString {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
//		System.out.println("Hello");

		ObjectMapper objectMapper = new ObjectMapper();
		String JsonObject = "{\"name\":\"sagar\",\"job\":\"Programmer\",\"tel\":98121,\"address\":\"Delhi\"}";

		Student student = objectMapper.readValue(JsonObject, Student.class);
//		System.out.println(student.getName());
//		System.out.println(student.getJob());

		JsonNode jsonNode = objectMapper.readTree(JsonObject);
		
		String name = jsonNode.get("name").asText() ;
		String job = jsonNode.get("job").asText() ;
		String tel = jsonNode.get("tel").asText() ;
		String address = jsonNode.get("address").asText() ;
		System.out.println(name);
		System.out.println(job);
		System.out.println(tel);
		System.out.println(address);

	}

}
