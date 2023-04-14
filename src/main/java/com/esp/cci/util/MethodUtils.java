package com.esp.cci.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class MethodUtils 
{
	private MethodUtils() {}
	public static Map<String, String> prepareErrorJSON(HttpStatus status, Exception ex)
	{
		HashMap<String, String> errorJson = new HashMap<>();
		errorJson.put("status", String.valueOf(status.value()));
		errorJson.put("error", status.getReasonPhrase());
		errorJson.put("message", ex.getMessage().split(":")[0]);
		
		return errorJson;
	}
}
