package control;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;

public class RequestProcessor {
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext application = request.getServletContext();
			String path = (String) application.getAttribute("path");
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			String formId = request.getParameter("formId");
			String actionclass = prop.getProperty(formId);
			model.Action action = (Action) Class.forName(actionclass).getConstructor().newInstance();
			String result = action.execute(request, response);
			String nextPage = prop.getProperty(result);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}