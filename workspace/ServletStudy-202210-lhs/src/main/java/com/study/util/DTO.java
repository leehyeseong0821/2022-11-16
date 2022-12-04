package com.study.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;

public class DTO {
	//date transfer object 데이터를 변환해주는객체
	private DTO() {	}
	
	public static Map<String,String> getParams(HttpServletRequest request) {
		Map<String,String> dataMap = new HashMap<>();		
		
		Set<String> keySet=request.getParameterMap().keySet();
		keySet.forEach(key ->{
			dataMap.put(key, request.getParameter(key));
		});
		
		return dataMap;
	}
}
