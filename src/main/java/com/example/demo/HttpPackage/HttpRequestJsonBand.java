package com.example.demo.HttpPackage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public class HttpRequestJsonBand {
	public static void main (String[]args) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "jon doe");
		map.put("age", "22");
		map.put("city", "chicago");
		JSONObject jo = new JSONObject(map);

}
}