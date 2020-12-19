package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse res, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object authinfo = session.getAttribute("authinfo");
			if (authinfo != null) {
				return true;
			}
		}
		res.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
}
