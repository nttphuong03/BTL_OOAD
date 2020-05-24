package com.FundManager.config;

import com.FundManager.service.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyDBAuthenticationService myDBAuthenticationService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}doanxem").roles("USER", "ADMIN");
//        auth.inMemoryAuthentication().withUser("admin1").password("{noop}dobiet123").roles("USER", "ADMIN");
        auth.userDetailsService(myDBAuthenticationService);
       auth.authenticationProvider(authenticationProvider());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      //  auth.authenticationProvider(authenticationProvider());
//    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myDBAuthenticationService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home").failureUrl("/login?error=true");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        http.authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers("/login").permitAll()
                                .antMatchers("/logout").permitAll()
                                .antMatchers("/user/signup").permitAll()
                                .antMatchers("/welcome").permitAll()
                                .antMatchers("/admin/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/home/**").access("hasRole('USER')");



    }
}
