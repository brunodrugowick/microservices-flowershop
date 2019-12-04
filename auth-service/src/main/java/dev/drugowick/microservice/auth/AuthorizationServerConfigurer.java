package dev.drugowick.microservice.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * This class configures the Authorization Server (oauth) with the Security stuff provided on the WeSecurityConfigurer.
 * 
 * @author drugo
 *
 */
@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	private AuthenticationManager authenticationManager;
	private UserDetailsService detailsService;
	private PasswordEncoder passwordEncoder;
	
	public AuthorizationServerConfigurer(AuthenticationManager authenticationManager, UserDetailsService detailsService,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.detailsService = detailsService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(detailsService);
	}
	
	@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory()
				.withClient("storefront")
				.secret(passwordEncoder.encode("storefront-password"))
				.authorizedGrantTypes("password")
				.scopes("web", "mobile");
		}
	
}
