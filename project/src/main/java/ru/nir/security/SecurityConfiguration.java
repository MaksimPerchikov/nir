package ru.nir.security;


import com.vaadin.flow.spring.security.VaadinWebSecurity;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.nir.model.Users;
import ru.nir.repository.RepositoryUsersInMemory;
import ru.nir.view.LoginView;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration
    extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            //.antMatchers("/api").access("@webSecurityClass.check(authentication,http)")
            .and().logout()
            .logoutSuccessUrl("/logout");

        super.configure(http);
        setLoginView(http, LoginView.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public RepositoryUsersInMemory createRepositoryUsersInMemory() {
        return new RepositoryUsersInMemory();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<Users> usersList = createRepositoryUsersInMemory().showAllUser();
        for (Users users1: usersList) {
            UserDetails user =  User.builder()
                .username(users1.getName())
                .password(passwordEncoder().encode(users1.getPassword()))
                .roles(users1.getRole())
                .build();

            return new InMemoryUserDetailsManager(user);
        }
        return null;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}