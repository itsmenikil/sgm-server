package in.mitransoftwares.ecommerce.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.mitransoftwares.ecommerce.security.auth.RestAuthenticationEntryPoint;
import in.mitransoftwares.ecommerce.security.filters.LoginFilter;
import in.mitransoftwares.ecommerce.security.filters.TokenAuthenticationFilter;
import in.mitransoftwares.ecommerce.service.usermodule.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	 @Value("${jwt.cookie}")
	    private String TOKEN_COOKIE;

	    @Value("${app.user_cookie}")
	    private String USER_COOKIE;

	    @Bean
	    public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
	        return new TokenAuthenticationFilter();
	    }

	    @Autowired
	    CustomUserDetailsService jwtUserDetailsService;
	    

	    @Autowired
	    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(jwtUserDetailsService);
	    }

	    @Autowired
	    private AuthenticationSuccessHandler authenticationSuccessHandler;

	    @Autowired
	    private AuthenticationFailureHandler authenticationFailureHandler;


	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .csrf()
	                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
	                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
	                .and()
	                .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint )
	                .and()
	                .authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/api/auth/login").permitAll()

	                .anyRequest().authenticated()

	                .and()

	                .addFilterBefore(new LoginFilter(new AntPathRequestMatcher("/api/auth/login")), UsernamePasswordAuthenticationFilter.class);
/*
	                .addFilterBefore(new AuthFilter(), UsernamePasswordAuthenticationFilter.class);
	                .addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
	                .authorizeRequests()
	                .antMatchers("/**")
	                    .authenticated()
	                 .and()
	                .formLogin()
	                    .successHandler(authenticationSuccessHandler)
	                    .failureHandler(authenticationFailureHandler).and()
	                .logout()
	                .deleteCookies(TOKEN_COOKIE, USER_COOKIE)
	                .logoutSuccessUrl("/login");//.antMatchers("/user").permitAll()
*/	    }
}
