package com.ssafy.dietboard.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dietboard")
public class DietBoardController extends HttpServlet {
	
	private static final String VIEW_PREFIX = "/WEB-INF/dietboard/";
	private static final String VIEW_SUFFIX = ".jsp";
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
		
		switch(act) {
		case "list":
			doList(request, response);
			break;
		case "mypage":
			doMyPage(request, response);
			break;
		default:
			break;
		}
	}

	private void doMyPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("menu", "mypage");
		forwardToView(request, response, "mypage");
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("menu", "diet");
		forwardToView(request, response, "meal");
	}
	
	private void forwardToView(HttpServletRequest request, HttpServletResponse response, String viewName) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_PREFIX + viewName + VIEW_SUFFIX).forward(request, response);
	}
}
