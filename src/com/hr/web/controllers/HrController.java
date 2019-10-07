package com.hr.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.web.command.Receiver;
import com.hr.web.command.Sender;
import com.hr.web.enums.Action;

@WebServlet("/hr.do")
public class HrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			request.setAttribute("page", "join");
			break;
		case JOIN:
			request.setAttribute("page", "login");
			break;
		case LOGIN:
			request.setAttribute("page", "mypage");
			break;

		default:
			break;
		}
		Sender.forward(request, response);
	}
}
