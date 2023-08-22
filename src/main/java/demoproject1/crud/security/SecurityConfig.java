package demoproject1.crud.security;



//import java.util.Base64.Encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	   @Bean
	    //authentication
	    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		   PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        UserDetails admin = User.withUsername("Shakul")
	                .password(encoder.encode("1234"))
	                .roles("ADMIN")
	                .build();
	        UserDetails user = User.withUsername("vasanth")
	                .password(encoder.encode("2345"))
	                .roles("USER")
	                .build();
	        return new InMemoryUserDetailsManager(admin, user);
	        
	    
	   }
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http.csrf().disable()
//	                .authorizeHttpRequests()
//	                .antMatchers("/spring_crud/v1/AddEmployee").permitAll()
//	                .and()
	                .authorizeHttpRequests().antMatchers("spring_crud/v1/GetEmployee")
	                .authenticated().and().formLogin().and().build();
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	    	 return  new BCryptPasswordEncoder();
	    }

}
