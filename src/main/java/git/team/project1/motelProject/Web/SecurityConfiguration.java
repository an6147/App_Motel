package git.team.project1.motelProject.Web;

import git.team.project1.motelProject.Services.iEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * Configuración de seguridad
 */
@Configuration
/*notacion para definifir el contexto de la clase*/

@EnableWebSecurity
/*notacion para definir que estamos personalizando la config de seguridad*/

public class SecurityConfiguration {

    @Autowired
    private iEmployeeService employeeService;

    @Bean
    public BCryptPasswordEncoder passWordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(employeeService);
        auth.setPasswordEncoder(passWordEncoder());
        return auth;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
       /*
    @Bean
    protected void configurer(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserBuilder users = User.withDefaultPasswordEncoder();

 
        UserDetails manager = users 
                .username("manager")
                .password("123")
                .roles("MANAGER")
                .build();

        UserDetails receptionist = users 
                .username("recep")
                .password("123")
                .roles("RECEPTIONIST")
                .build();

        UserDetails cleanliness = users 
                .username("clean")
                .password("123")
                .roles("CLEANLINESS")
                .build();

        return new InMemoryUserDetailsManager(manager, receptionist, cleanliness);
    }*/
    @Bean
    /*Bean de autorización*/
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz -> authz
                .requestMatchers("/register**", "/js/**", "/css/**", "/img/**")
                .permitAll()
                .anyRequest()
                .authenticated()))
                .formLogin(form -> form
                .loginPage("/login")
                .permitAll())
                .logout((logout) -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll());

        return http.build();
    }

}
