package in.mitransoftwares.ecommerce.security.filters;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import in.mitransoftwares.ecommerce.service.usermodule.CustomUserDetailsService;



public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	
	public LoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
		// TODO Auto-generated constructor stub
	}


	@Autowired
	CustomUserDetailsService customUserDetailService;
	
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 UserDetails user=null;
		 if(customUserDetailService!=null){
			  user=customUserDetailService.loadUserByUsername(username);
		 }
		
		 
		 
		 if(user==null||!user.getUsername().equalsIgnoreCase(username)){
			 throw new BadCredentialsException("Invalid User Name");
		 }
		 
		 if(!user.getPassword().equals(password)){
			 throw new BadCredentialsException("Invalid Password");
		 }
		 
		 Collection<? extends GrantedAuthority> authorities=user.getAuthorities();
		 
		return new UsernamePasswordAuthenticationToken(user,user.getPassword(),authorities);
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
	}	

}
