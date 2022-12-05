package com.study.servlet.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.AccountSerivce;
import com.study.util.DTO;

@WebServlet("/auth/register")
public class RegisterApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> registerParmas =DTO.getParams(request);
		AccountSerivce accountService = AccountSerivce.getInstance();
		
		if(accountService.getInstance().duplicateUsername(registerParmas.get("username"))) {
		 System.out.println("아이디가 중복되었습니다.");
		 request.getRequestDispatcher("/WEB-INF/account/error_username.html").forward(request, response);
		 return;
		 
		}	
		System.out.println("가입 가능합니다.");
		User user = User.builder()
				.username(registerParmas.get("username"))
				.password(registerParmas.get("password"))
				.name(registerParmas.get("name"))
				.email(registerParmas.get("email"))
				.roles("ROLE_USER,ROLE_ADMIN")
				.build();
		
		 accountService.register(user);
		 
		 UserRepository.getInstance().showUserAll();
		 
		 response.sendRedirect("/login");
	
	}
}
