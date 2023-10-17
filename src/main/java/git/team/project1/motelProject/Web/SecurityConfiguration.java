package git.team.project1.motelProject.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * Configuración de seguridad
 */
@Configuration
/*notacion para definifir el contexto de la clase*/
@EnableWebSecurity
/*notacion para definir que estamos personalizando la config de seguridad*/

public class SecurityConfiguration {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {/*autenticacion en memoria*/
        UserBuilder users = User.withDefaultPasswordEncoder();/*Objeto de tipo ensamblador de usuario*/

 /*Usuarios en memoria, para pruebas*/
        UserDetails manager = users /*manager con las caracteristicas de users*/
                .username("manager")
                .password("123")
                .roles("MANAGER")
                .build();
        
        UserDetails receptionist = users /*receptionist con las caracteristicas de users*/
                .username("recep")
                .password("123")
                .roles("RECEPTIONIST")
                .build();
        
        UserDetails cleanliness = users /*receptionist con las caracteristicas de users*/
                .username("clean")
                .password("123")
                .roles("CLEANLINESS")
                .build();
        
        return new InMemoryUserDetailsManager(manager, receptionist, cleanliness);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz -> authz
                        .requestMatchers("/manager").hasRole("MANAGER")
                        .requestMatchers("/reception").hasRole("RECEPTIONIST")
                        .requestMatchers("/rooms").hasRole("CLEANLINESS")
                        .anyRequest().authenticated()))
                .formLogin(form -> form.loginPage("/login").permitAll())
                .exceptionHandling((exceptionHandling) -> exceptionHandling
                        .accessDeniedPage("/403"));
        
        return http.build();
    }
    
}
