package com.example.bankapplicationrestsecurity.config;

import com.example.bankapplicationrestsecurity.filter.AuthoritiesLogginAtFilter;
import com.example.bankapplicationrestsecurity.filter.AuthoritiesLogginAtferFilter;
import com.example.bankapplicationrestsecurity.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.
        cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(Collections.singletonList("http://my-front-app/url"));
                        configuration.setAllowedMethods(Collections.singletonList("*"));
                        configuration.setAllowCredentials(true);
                        configuration.setAllowedHeaders(Collections.singletonList("*"));
                        configuration.setMaxAge(3600L);
                        return configuration;
                    }
                })
                .and()
                .csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AuthoritiesLogginAtFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLogginAtferFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/loan").hasRole("ADMIN")
                .antMatchers("/account").hasAnyRole("ADMIN", "USER")
                .antMatchers("/balance").hasRole("MANAGER")
                .antMatchers("/card").hasRole("MODERATOR")
                .antMatchers("/contact", "/notice", "/auth/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().formLogin();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
