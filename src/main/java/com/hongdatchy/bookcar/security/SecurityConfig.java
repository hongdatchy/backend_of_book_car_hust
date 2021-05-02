package com.hongdatchy.bookcar.security;

import com.hongdatchy.bookcar.repo.DriverRepo;
import com.hongdatchy.bookcar.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final UserRepo userRepo;
    private final DriverRepo driverRepo;
    private final JWTService jwtService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .maximumSessions(1);
    }

    @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilterUser() {
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTFilter(userRepo, driverRepo, jwtService));
        registrationBean.addUrlPatterns("/api/us/*", "/api/dv/*");
        return registrationBean;
    }

}
