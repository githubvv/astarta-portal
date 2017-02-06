package astarta.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import astarta.db.dao.OrgStructureDao;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.exception.AbstractPortalDBException;

public class LdapAuthenticationProviderExt extends LdapAuthenticationProvider {
	private static final Logger logger = LoggerFactory.getLogger(LdapAuthenticationProviderExt.class);

	@Autowired
	private OrgStructureDao orgStructureDao;

	public LdapAuthenticationProviderExt(LdapAuthenticator authenticator,
			LdapAuthoritiesPopulator authoritiesPopulator) {
		super(authenticator, authoritiesPopulator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication, this.messages.getMessage(
				"LdapAuthenticationProvider.onlySupports", "Only UsernamePasswordAuthenticationToken is supported"));

		final UsernamePasswordAuthenticationToken userToken = (UsernamePasswordAuthenticationToken) authentication;

		String username = userToken.getName();
		String password = (String) authentication.getCredentials();

		if (logger.isDebugEnabled()) {
			logger.debug("Processing authentication request for user: " + username);
		}

		if (!StringUtils.hasLength(username)) {
			throw new BadCredentialsException(
					this.messages.getMessage("LdapAuthenticationProvider.emptyUsername", "Empty Username"));
		}

		if (!StringUtils.hasLength(password)) {
			throw new BadCredentialsException(
					this.messages.getMessage("AbstractLdapAuthenticationProvider.emptyPassword", "Empty Password"));
		}

		Assert.notNull(password, "Null password was supplied in authentication token");

		DirContextOperations userData = doAuthentication(userToken);
		String email = userData.getStringAttribute("mail");

		// Get user account by email from users table
		UserEnt userEnt = null;
		try {
			userEnt = orgStructureDao.getUserDB(email, TypeUserKey.EMAIL);
		} catch (AbstractPortalDBException e) {
			logger.debug("Data is not found. Getting user account by email [{}] field in [users] table.", email);
			throw new UsernameNotFoundException(e.getMessage(), e);
		}

		// Set param userEnt.getUsername() instead of authentication.getName()
		// to loadUserAuthorities method.
		LdapUserDetails userDetails = (LdapUserDetails) this.userDetailsContextMapper.mapUserFromContext(userData,
				authentication.getName(),
				loadUserAuthorities(userData, userEnt.getUsername(), (String) authentication.getCredentials()));
		// Create UserDetailsExt with UserEnt object for save in Principal
		UserDetailsExt userDetailsExt = new UserDetailsExt(userEnt, userDetails.getDn(), userDetails.getPassword(),
				userDetails.getUsername(), userDetails.getAuthorities(), userDetails.isAccountNonExpired(),
				userDetails.isAccountNonLocked(), userDetails.isCredentialsNonExpired(), userDetails.isEnabled());

		return createSuccessfulAuthentication(userToken, userDetailsExt);
	}
}
