package com.gangadhar.springsecurityauthenticationauthorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gangadhar.springsecurityauthenticationauthorization.repository.UserRepository;
import com.gangadhar.springsecurityauthenticationauthorization.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("**/secured/**").authenticated()
		.anyRequest().permitAll().and().formLogin().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());

	}

	private PasswordEncoder getPasswordEncoder() {

		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence arg0, String arg1) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public String encode(CharSequence charSequence) {
				// TODO Auto-generated method stub
				return charSequence.toString();
			}
		};
	}

}
