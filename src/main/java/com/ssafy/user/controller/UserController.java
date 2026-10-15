package com.ssafy.user.controller;

import java.io.IOException;

import com.ssafy.user.model.dto.UserDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class UserController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		
			
			UserDto login = new UserDto();
			login.setId(Id);
			login.setPw(Pw);
			
			UserDao loginDao = UserDao.getInstance();
			login = loginDao.selectLogin(login);
			
			//성공: main.jsp
			//실패: loginForm.jsp로 이동시키기
			
			if(login == null) {
				response.sendRedirect(request.getContextPath()+"/login?act=loginForm");
			
			} else {
				//session실행
				HttpSession session = request.getSession();
				session.setAttribute("login",login);
				
				response.sendRedirect(request.getContextPath()+"/main");
			}
			
			
		
		
	}
}
