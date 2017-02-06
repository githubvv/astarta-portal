package astarta.security.config;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import astarta.db.entity.UserEnt;

public class UserDetailsExt implements UserDetails {
	private static final long serialVersionUID = -3755125870874146277L;
	private final UserEnt userData;
	private final String dn;
	private final String password;
	private final String username;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean accountNonExpired;
	private final boolean accountNonLocked;
	private final boolean credentialsNonExpired;
	private final boolean enabled;
	
	public UserDetailsExt(UserEnt userData, String dn, String password, String username, Collection<? extends GrantedAuthority> authorities,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		this.userData = userData;
		this.dn = dn;
		this.password = password;
		this.username = username;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public UserEnt getUserData() {
		return userData;
	}
	public String getDn() {
		return dn;
	}
	
}
