package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);

		//hardcoding option to add users
		/*// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER", "EMPLOYEE"))
			.withUser(users.username("susan").password("test123").roles("ADMIN", "EMPLOYEE"));*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // restrict access based on the HttpServletRequest
	//	.anyRequest().authenticated() //any request to the app must be authenticated
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				//allow this path only for given role
		.and()
				.formLogin() //we are customizing the form login process
		.loginPage("/showMyLoginPage") //show our customer form at the request mapping
		.loginProcessingUrl("/authenticateTheUser") //login form should POST data to this URL for processing
		.permitAll() //allow everyone to see login page. No need to be logged in
		.and().logout().permitAll() //add logout support
		.and() //define routing for custom access denied page
				.exceptionHandling().accessDeniedPage("/access-denied");

	}
}






