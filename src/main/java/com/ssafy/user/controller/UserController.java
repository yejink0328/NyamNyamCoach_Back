package com.ssafy.user.controller;

import java.io.IOException;

import com.ssafy.user.model.dto.UserDto;
import com.ssafy.user.model.service.UserService;
import com.ssafy.user.model.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private final UserService service = UserServiceImpl.getInstance();

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String act = request.getParameter("act");

        if (act == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // 로그인, 로그아웃, 회원가입 처리는 POST 요청만 허용
        if (("login".equals(act)
                || "logout".equals(act)
                || "signup".equals(act))
                && !"POST".equals(request.getMethod())) {

            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return;
        }

        switch (act) {
        case "signupform":
            // 회원가입 화면 열기
            request.getRequestDispatcher("/WEB-INF/user/signup.jsp")
                   .forward(request, response);
            return;

        case "signup":
            // 입력한 회원 정보를 저장
            doSignup(request, response);
            return;

        case "login":
            doLogin(request, response);
            return;

        case "logout":
            doLogout(request, response);
            return;

        case "mypage":
            doMyPage(request, response);
            return;

        default:
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
    }
//    @Override
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//
//        if ("/login".equals(request.getServletPath())) {
//            doLogin(request, response);
//            return;
//        }
//
//        String act = request.getParameter("act");
//
//        if ("logout".equals(act)) {
//            doLogout(request, response);
//        } else {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }

    	// 회원가입 처리
    	private void doSignup(HttpServletRequest request,
    	        HttpServletResponse response)
    	        throws ServletException, IOException {

    	    try {
    	        String id = request.getParameter("Id");
    	        String pw = request.getParameter("Pw");
    	        String confirmPw = request.getParameter("confirmPw");

    	        if (pw == null || !pw.equals(confirmPw)) {
    	            throw new IllegalArgumentException(
    	                    "비밀번호 확인이 일치하지 않습니다.");
    	        }

    	        UserDto user = new UserDto();

    	        user.setId(id == null ? null : id.trim());
    	        user.setPw(pw);
    	        user.setUserName(request.getParameter("name"));

    	        try {
    	            user.setUserHeight(
    	                    Integer.parseInt(request.getParameter("height")));

    	            user.setUserWeight(
    	                    Double.parseDouble(request.getParameter("weight")));

    	        } catch (NumberFormatException | NullPointerException e) {
    	            throw new IllegalArgumentException(
    	                    "키와 몸무게를 숫자로 입력하세요.");
    	        }

    	        service.signup(user);

    	        // 가입 성공 후 홈으로 이동
    	        response.sendRedirect(request.getContextPath() + "/");
    	        return;

    	    } catch (IllegalArgumentException e) {
    	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	        request.setAttribute("error", e.getMessage());

    	    } catch (IllegalStateException e) {
    	        log("회원가입 실패", e);
    	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    	        request.setAttribute(
    	                "error", "회원가입 처리 중 오류가 발생했습니다.");
    	    }

    	    // 실패하면 오류 메시지와 함께 가입 화면 표시
    	    request.getRequestDispatcher("/WEB-INF/user/signup.jsp")
    	           .forward(request, response);
    	
    }

	// 로그인
    private void doLogin(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("Id");
        String pw = request.getParameter("Pw");

        UserDto loginUser = service.login(id, pw);

        if (loginUser == null) {
            request.setAttribute(
                    "error", "아이디 또는 비밀번호가 일치하지 않습니다.");

            request.getRequestDispatcher("/WEB-INF/user/login.jsp")
                   .forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        request.changeSessionId();

        session.setAttribute("login", loginUser);
        session.setAttribute("userId", loginUser.getUUID());

//        response.sendRedirect("index.jsp");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    // 마이페이지
    private void doMyPage(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // 로그인하지 않았다면 로그인 화면으로 이동
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        // 요청 파라미터가 아닌 로그인 세션에서 회원 번호 사용
        int uuid = (Integer) session.getAttribute("userId");

        UserDto user = service.getUser(uuid);

        // DB에 회원이 없는 경우
        if (user == null) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/user/mypage.jsp")
               .forward(request, response);
    }

    // 로그아웃
    private void doLogout(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

//        response.sendRedirect(request.getContextPath() + "/");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}