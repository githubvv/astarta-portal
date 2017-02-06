package astarta.security.config;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
	Authentication getAuthentication();
}
