package in.mitransoftwares.ecommerce.service.usermodule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.mitransoftwares.ecommerce.entity.usermodule.Privilege;
import in.mitransoftwares.ecommerce.entity.usermodule.User;
import in.mitransoftwares.ecommerce.entity.usermodule.UserRole;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.userByUserName(username);
		 if(user==null){
			 throw new UsernameNotFoundException("Invalid Email Id");
		 }else{
			 boolean status=false;
			 
			 //Need Changes Here
			 /*if(user.getStatus()==1){
				 status=true;
			 }*/
			 
			return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),status,true,true,true,getAuthorities(user.getUserRoles()));
		 }
	}
	
	
	private Collection<? extends GrantedAuthority> getAuthorities(Collection<UserRole> userRoles) {
		 return getGrantedAuthorities(getPrivileges(userRoles));
    }
	
	
	
	 private List<String> getPrivileges(Collection<UserRole> userRoles) {
	        List<String> privileges = new ArrayList<String>();
	        List<Privilege> collection = new ArrayList<Privilege>();
	        for (UserRole role : userRoles) {
	            collection.addAll(role.getPrivileges());
	        }
	        for (Privilege item : collection) {
	            privileges.add(item.getPrivilegeName());
	        }
	        return privileges;
	  }
	
	 
	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : privileges) {
        	authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
