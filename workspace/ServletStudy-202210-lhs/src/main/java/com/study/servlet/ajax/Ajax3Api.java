package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


@WebServlet("/api/ajax3")
public class Ajax3Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonData = request.getParameter("data");
		Map<String, Object> dataMap = gson.fromJson(jsonData, Map.class);
		/*List<String> phoneNumbers = new ArrayList<>();
		
		dataMap.forEach((key,value)->{
			if(value.getClass()== String.class) {
			phoneNumbers.add((String)value);
			}
		});*/
		
		response.setContentType("application/json; charset=utf8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String str ="문자열1";
		str = str+"문자열2";
		str = str+"문자열3";
		
		//문자열을 합칠때 쓴다.
		StringBuilder stringBuilder = new StringBuilder();
		
		dataMap.forEach((key,value)->{
			stringBuilder.append(value); //append 문자열을 더 한다.
			stringBuilder.append("-");
		});
		
		stringBuilder.delete(stringBuilder.length() -1, stringBuilder.length());
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("responseData", stringBuilder.toString());
		
		out.print(jsonObject.toString());
		
	}

}
