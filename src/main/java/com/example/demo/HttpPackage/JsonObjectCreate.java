package com.example.demo.HttpPackage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectCreate {
	public static void main(String[]args) {
		Car car = new Car("yellow", "renault");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String carAsString = objectMapper.writeValueAsString(car);
			System.out.println(carAsString);
		}catch(JsonProcessingException e){
			e.printStackTrace();
		}
		
	}
	
	

}
