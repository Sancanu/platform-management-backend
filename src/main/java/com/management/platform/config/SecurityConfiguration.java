package com.management.platform.config;


import com.management.platform.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.management.platform.entity.Permission.*;
import static com.management.platform.entity.Role.ADMIN;
import static com.management.platform.entity.Role.MANAGER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutService logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**")
                .permitAll()
                .requestMatchers("/management/**").hasAnyRole(ADMIN.name(),MANAGER.name())
                .requestMatchers(HttpMethod.GET,"/management/**").hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
                .requestMatchers(HttpMethod.POST,"/management/**").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
                .requestMatchers(HttpMethod.PUT,"/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE,"/management/**").hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())
                /*
                .requestMatchers("/admin/**").hasRole(ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(HttpMethod.PUT, "/admin/**").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE, "/admin/**").hasAuthority(ADMIN_DELETE.name())
                */
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/user/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) ->
                        SecurityContextHolder.clearContext()
                );




        return  http.build();

    }
}
