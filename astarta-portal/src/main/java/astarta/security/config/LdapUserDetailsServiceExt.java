package astarta.security.config;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.search.LdapUserSearch;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.util.Assert;
import astarta.db.dao.OrgStructureDao;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.exception.AbstractPortalDBException;

public class LdapUserDetailsServiceExt implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(LdapUserDetailsServiceExt.class);

	@Autowired
	private OrgStructureDao orgStructureDao;

	private final LdapUserSearch userSearch;
	private final LdapAuthoritiesPopulator authoritiesPopulator;
	private UserDetailsContextMapper userDetailsMapper = new LdapUserDetailsMapper();

	public LdapUserDetailsServiceExt(LdapUserSearch userSearch) {
		this(userSearch, new NullLdapAuthoritiesPopulator());
	}

	public LdapUserDetailsServiceExt(LdapUserSearch userSearch, LdapAuthoritiesPopulator authoritiesPopulator) {
		Assert.notNull(userSearch, "userSearch must not be null");
		Assert.notNull(authoritiesPopulator, "authoritiesPopulator must not be null");
		this.userSearch = userSearch;
		this.authoritiesPopulator = authoritiesPopulator;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DirContextOperations userData = userSearch.searchForUser(username);

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
		LdapUserDetails userDetails = (LdapUserDetails) userDetailsMapper.mapUserFromContext(userData, username,
				authoritiesPopulator.getGrantedAuthorities(userData, userEnt.getUsername()));

		// Create UserDetailsExt with UserEnt object for save in Principal
		UserDetailsExt userDetailsExt = new UserDetailsExt(userEnt, userDetails.getDn(), userDetails.getPassword(),
				userDetails.getUsername(), userDetails.getAuthorities(), userDetails.isAccountNonExpired(),
				userDetails.isAccountNonLocked(), userDetails.isCredentialsNonExpired(), userDetails.isEnabled());

		return userDetailsExt;
	}

	public void setUserDetailsMapper(UserDetailsContextMapper userDetailsMapper) {
		Assert.notNull(userDetailsMapper, "userDetailsMapper must not be null");
		this.userDetailsMapper = userDetailsMapper;
	}

	private static final class NullLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
		public Collection<GrantedAuthority> getGrantedAuthorities(DirContextOperations userDetails, String username) {
			return AuthorityUtils.NO_AUTHORITIES;
		}
	}

}
