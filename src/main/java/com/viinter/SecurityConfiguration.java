package com.viinter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	
	@Override
	public void configure( final WebSecurity web ) throws Exception
	{
		// This is here to ensure that the static content (JavaScript, CSS, etc)
		// is accessible from the login page without authentication
		web
		.ignoring()
		.antMatchers( "/WEB-INF/views/**" );

	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth)
			throws Exception {
		LOGGER.info("Using custom authentications service");
		auth.inMemoryAuthentication().withUser("testuser").password("password").roles("ADMIN");
		//TODO: security with DB
		//auth.userDetailsService(customUserDetailsService);

	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http
		// access-denied-page: this is the page users will be
		// redirected to when they try to access protected areas.
		.exceptionHandling()
		.accessDeniedPage( "/accessdenied" )
		.and()
		// The intercept-url configuration is where we specify what roles are allowed access to what areas.
		.authorizeRequests()
		.antMatchers("/**").permitAll();
		/*.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl( "/homepage" )
		//Handling Logout
		.and()
		.logout().logoutSuccessUrl("/logout"); */
		http.csrf().disable();
	}
	
	
	
	
	
	
}
