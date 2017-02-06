package astarta.security.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;
import astarta.web.config.jackson.JsonMapper;

public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private JsonMapper jacksonMapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
        ObjectNode authJSON = jacksonMapper.createObjectNode();  
        authJSON.put("status","fail");

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(authJSON);
	}
}
