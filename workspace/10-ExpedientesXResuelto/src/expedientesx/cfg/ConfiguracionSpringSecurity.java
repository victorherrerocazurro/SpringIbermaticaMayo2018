package expedientesx.cfg;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled= true, prePostEnabled = true)
public class ConfiguracionSpringSecurity extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Fernando").password("1234").roles("AGENTE");
		auth.inMemoryAuthentication().withUser("Mulder").password("fox").roles("AGENTE_ESPECIAL");
		auth.inMemoryAuthentication().withUser("Scully").password("dana").roles("AGENTE_ESPECIAL");
		auth.inMemoryAuthentication().withUser("Skinner").password("walter").roles("DIRECTOR");
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	public UserDetailsService userDetailsService(){
	    Properties usuarios = new Properties();
		usuarios.put("Fernando","$2a$10$SMPYtil7Hs2.cV7nrMjrM.dRAkuoLdYM8NdVrF.GeHfs/MrzcQ/zi,ROLE_AGENTE,enabled");
		usuarios.put("Mulder"  ,"$2a$10$M2JRRHUHTfv4uMR4NWmCLebk1r9DyWSwCMZmuq4LKbImOkfhGFAIa,ROLE_AGENTE_ESPECIAL,enabled");
		usuarios.put("Scully"  ,"$2a$10$cbF5xp0grCOGcI6jZvPhA.asgmILATW1hNbM2MEqGJEFnRhhQd3ba,ROLE_AGENTE_ESPECIAL,enabled");
		usuarios.put("Skinner" ,"$2a$10$ZFtPIULMcxPe3r/5VunbVujMD7Lw8hkqAmJlxmK5Y1TK3L1bf8ULG,ROLE_DIRECTOR,enabled");
	    
		return new InMemoryUserDetailsManager(usuarios);
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth, PasswordEncoder pe) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(pe);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Filtros de acceso a recursos libres y asegurados
		
		http
			.authorizeRequests()
				.antMatchers("/paginas/*").permitAll()
				.antMatchers("/css/*").permitAll()
				.antMatchers("/imagenes/*").permitAll()
				.antMatchers("/**").access("hasAnyRole('AGENTE','AGENTE_ESPECIAL','DIRECTOR')");
		
		//login
		
		http
			.formLogin()
				.loginPage("/paginas/nuestro-login.jsp")
				.failureUrl("/paginas/nuestro-login.jsp?login_error");

		//logout
		
		http
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)  
				.logoutSuccessUrl("/paginas/desconectado.jsp")
				.deleteCookies("JSESSIONID");

		//Desactivar CSRF para evitar sobre configuracion
		
		http
			.csrf()
				.disable();
		
		//Remember me
		
		http
			.rememberMe()
				.rememberMeParameter("remember-me-param")
				.rememberMeCookieName("my-remember-me")
				.tokenValiditySeconds(86400);
		
		//Activacion de seguridad en el transporte https y redireccion de puertos
		
		http
			.requiresChannel()
				.anyRequest().requiresSecure()
		.and()
			.portMapper()
				.http(8080).mapsTo(8443);
		
		//Limite de sesiones abiertas por usuario
		
		http
			.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true);
		
		//SessionFixation y migracion de sesiones
		
		http
			.sessionManagement()
	    		.sessionFixation()
	    		.migrateSession();

		//Pagina de error para accesos a metodos no autorizados
		
		http
			.exceptionHandling()
				.accessDeniedPage("/paginas/acceso-denegado.jsp");
		
	}
}
