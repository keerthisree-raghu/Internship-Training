package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class RegistrationAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(Integer.parseInt(userId));
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		userDTO.setFlag(0);
		
		Properties prop = (Properties) request.getServletContext().getAttribute("properties");

		LoginService loginService = LoginServiceImpl.getLoginServiceImpl(prop);
		
		loginService.registerUser(userDTO);
		
		return "register.success";
	}

}
