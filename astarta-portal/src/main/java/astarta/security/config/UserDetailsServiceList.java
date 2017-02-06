package astarta.security.config;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceList implements UserDetailsService {
	private List<UserDetailsService> list;
	
	public UserDetailsServiceList(List<UserDetailsService> list) {
		super();
		this.list = list;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try{
			userDetails = list.get(0).loadUserByUsername(username);
		}
		catch(UsernameNotFoundException ex){
			userDetails = list.get(1).loadUserByUsername(username);
		}
		
		return userDetails;
	}

}
