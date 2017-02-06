package astarta.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;
import astarta.web.config.jackson.JsonMapper;


public class AuthSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired 
	private JsonMapper jacksonMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		HttpSession session = request.getSession();
		
		UserDetailsExt authUser = (UserDetailsExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        session.setAttribute("username", authUser.getUsername());  
        session.setAttribute("authorities", authentication.getAuthorities()); 
        String userDetails = jacksonMapper.writeValueAsString(authUser.getUserData());
       
        ObjectNode authJSON = jacksonMapper.createObjectNode();
        authJSON.put("status","success");
        authJSON.put("userdetails",userDetails);
     
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(authJSON);
        response.getWriter().flush();
	}
}

