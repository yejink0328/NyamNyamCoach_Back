package com.ssafy.user.controller;

import java.io.IOException;

import com.ssafy.user.model.dto.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class UserController extends HttpServlet {

    // 로그인 페이지 이동
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/login.jsp")
               .forward(request, response);
    }

    // 로그인 처리
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String Id = request.getParameter("Id");
        String Pw = request.getParameter("Pw");

        UserDto user = new UserDto();
        user.setId(Id);
        user.setPw(Pw);

        // 임시 로그인 검증
        // 나중에 UserDao로 교체
        boolean success = "ssafy".equals(Id)
                       && "1234".equals(Pw);

        if (success) {

            HttpSession session = request.getSession();
            session.setAttribute("login", user);

            response.sendRedirect(
                request.getContextPath() + "/"
            );
            
            System.out.println("로그인성공");

        } else {

            response.sendRedirect(
                request.getContextPath() + "/login?error=1"
            );
            System.out.println("로그인실패");
        }
    }
}