package myfilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

	public AdminFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		boolean loggedIn = session != null && session.getAttribute("username") != null;
		boolean loginRequest = req.getRequestURI().endsWith("/LoginController");
		boolean regisRequest = req.getRequestURI().endsWith("/RegisterController");

		if (req.getRequestURI().indexOf("/css") > 0) {
			chain.doFilter(request, response);
		} else if (req.getRequestURI().indexOf("/js") > 0) {
			chain.doFilter(request, response);
		} else if (req.getRequestURI().indexOf("/fonts") > 0) {
			chain.doFilter(request, response);
		}

		else if (loggedIn || loginRequest || regisRequest) {
			chain.doFilter(request, response);
		}

		else {
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
