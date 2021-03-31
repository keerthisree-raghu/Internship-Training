package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class LoginAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Properties prop = (Properties) request.getServletContext().getAttribute("properties");
		HttpSession session = request.getSession();

		LoginService loginService = LoginServiceImpl.getLoginServiceImpl(prop);
		
		if (loginService.checkUser(username, password)) {
			if (loginService.checkFlag(username)) {
				int custno=loginService.getcustno(username);
				session.setAttribute("username", username);
				session.setAttribute("custno", custno);
				loginService.updateFlag(username, 1);
				return "login.success";
			} else {
				return "login.loggedIn";
			}
		} else {
			return "login.failure";
		}
	}
}
