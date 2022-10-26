/*
package ru.nir.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/**").authorizeRequests()
            .antMatchers("/hi").permitAll()
            .anyRequest().authenticated()
            .and()
        */
/*.oauth2Client();*//*

            .httpBasic();
    }

    */
/*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(passwordEncoder);
       // provider.setUserDetailsService(applicationUserService);
        return provider;
    }*//*


    */
/*@Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetailsService userFirst = User.builder()
            .username("max")
            .password("123")
            .build();
        return new
    }*//*

}
*/
