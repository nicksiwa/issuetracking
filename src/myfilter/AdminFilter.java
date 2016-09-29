package myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
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
		HttpSession session = req.getSession();

		if (req.getRequestURI().indexOf("/css") > 0) {
			chain.doFilter(request, response);
		} else if (req.getRequestURI().indexOf("/js") > 0) {
			chain.doFilter(request, response);
		} else if (req.getRequestURI().indexOf("/fonts") > 0) {
			chain.doFilter(request, response);
		}
		else if (session.getAttribute("username") == null && !req.getRequestURI().endsWith("/LoginController")) {
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		} else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
