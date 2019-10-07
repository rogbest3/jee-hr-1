package com.hr.web.command;

import javax.servlet.http.HttpServletRequest;

import com.hr.web.enums.Action;

public class Commander {
	public static Command direct(HttpServletRequest request) {
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		case LOGIN:
			cmd = new LoginCommand(request);
			break;
		case JOIN:
			cmd = new JoinCommand(request);
			break;
		case SEARCH:
			cmd = new SearchCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}
}
