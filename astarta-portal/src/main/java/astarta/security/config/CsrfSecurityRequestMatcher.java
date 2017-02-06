package astarta.security.config;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CsrfSecurityRequestMatcher implements RequestMatcher {
	@Value("${server1cIP}")
	private String ipAdress;

	private AntPathRequestMatcher[] notVerifyReqMatchers = { new AntPathRequestMatcher("/**/load-from-1c") };
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	@Override
	public boolean matches(HttpServletRequest request) {
		if (allowedMethods.matcher(request.getMethod()).matches())
			return false;
		if (request.getRemoteAddr().equals(ipAdress)) {
			for (AntPathRequestMatcher rm : notVerifyReqMatchers) {
				if (rm.matches(request))
					return false;
			}
		}
		return true;
	}
}