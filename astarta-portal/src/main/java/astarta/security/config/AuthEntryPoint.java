package astarta.security.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component("authEntryPoint")
public class AuthEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
	/*	if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		} else
			response.sendRedirect(request.getContextPath() + "/html/login.html");
*/	
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		
		//SET WWW-Authenticate header 
	}
}