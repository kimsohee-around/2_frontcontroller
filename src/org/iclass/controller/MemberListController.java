package org.iclass.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListController implements Controller{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hello", "안녕~!!반가워~~^^");
		//hello는 데이터이름(변수명 취급) , "안녕~~~~" 는 데이터 (데이터 타입은 Object)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/list.jsp");
		dispatcher.forward(request, response);
	}
}
