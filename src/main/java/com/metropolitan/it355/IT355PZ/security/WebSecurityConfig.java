package com.metropolitan.it355.IT355PZ.security;

import com.metropolitan.it355.IT355PZ.jwt.filters.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private AuthenticationProvider authenticationProvider;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(
                        cors -> cors.configurationSource(request -> {
                            CorsConfiguration corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                            corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
                            corsConfiguration.setAllowCredentials(true);
                            return corsConfiguration;
                        })
                )
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests( authConfig -> authConfig
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET , "/images/**").permitAll()

                        .requestMatchers("/error").permitAll()
                        //Logout
                        .requestMatchers(HttpMethod.POST , "/auth/logout").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                        //Korisnici
                        .requestMatchers(HttpMethod.GET ,"/korisnici/**").hasAuthority("FULL_ACCESS")
                        //Artikli
                        .requestMatchers("/artikli/**").hasAnyAuthority("FULL_ACCESS" , "READ_ONLY")
                        .requestMatchers(HttpMethod.GET , "/artikli/**").hasAnyAuthority("READ_ONLY" , "FULL_ACCESS")
                        .requestMatchers(HttpMethod.POST , "/artikli/**").hasAnyAuthority("FULL_ACCESS")
                        .requestMatchers(HttpMethod.PUT , "/artikli/**").hasAnyAuthority("FULL_ACCESS", "READ_ONLY")
                        .requestMatchers(HttpMethod.DELETE , "/artikli/**").hasAnyAuthority("FULL_ACCESS")
                        //Meni
                        .requestMatchers(HttpMethod.GET, "/meni/**").hasAnyAuthority("FULL_ACCESS", "READ_ONLY")
                        .requestMatchers(HttpMethod.POST, "/meni/**").hasAnyAuthority("FULL_ACCESS", "READ_ONLY")
                        .requestMatchers(HttpMethod.PUT, "/meni/**").hasAnyAuthority("FULL_ACCESS", "READ_ONLY")
                        .requestMatchers(HttpMethod.DELETE, "/meni/**").hasAnyAuthority("FULL_ACCESS", "READ_ONLY")
                        //Admin

                        .requestMatchers("/admin/**").hasAuthority("FULL_ACCESS")
                        .requestMatchers("/actuator/**").hasAuthority("FULL_ACCESS")
                        //.requestMatchers("/actuator/**").permitAll()
                        .anyRequest().denyAll());

        return http.build();

    }

}
