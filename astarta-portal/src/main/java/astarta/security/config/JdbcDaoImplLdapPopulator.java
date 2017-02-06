package astarta.security.config;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import astarta.db.dao.OrgStructureDao;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.exception.AbstractPortalDBException;

public class JdbcDaoImplLdapPopulator extends JdbcDaoImpl implements LdapAuthoritiesPopulator {
	private static final Logger logger = LoggerFactory.getLogger(JdbcDaoImplLdapPopulator.class);

	@Autowired
	private OrgStructureDao orgStructureDao;

	// DB authentication. For create UserDetails with UserEnt(user account) from
	// DB
	@Override
	public UserDetails loadUserByUsername(String username) {
		UserDetails userDetails = super.loadUserByUsername(username);
		try {
			UserEnt userEnt = orgStructureDao.getUserDB(username, TypeUserKey.USERNAME);
			userEnt.setPassword("");

			UserDetailsExt userDetailsExt = new UserDetailsExt(userEnt, null, userDetails.getPassword(),
					userDetails.getUsername(), userDetails.getAuthorities(), userDetails.isAccountNonExpired(),
					userDetails.isAccountNonLocked(), userDetails.isCredentialsNonExpired(), userDetails.isEnabled());
			return userDetailsExt;

		} catch (AbstractPortalDBException e) {
			logger.debug("Data is not found. Getting user account by username [{}] field in [users] table.", username);
			throw new UsernameNotFoundException(e.getMessage(), e);
		}
	}

	// For getting AD authority from DB.
	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData,
			String username) {
		List<GrantedAuthority> authList = loadGroupAuthorities(username);
		if (authList.size()==0)
			throw new UsernameNotFoundException(username);
		return authList; 
	}
}
