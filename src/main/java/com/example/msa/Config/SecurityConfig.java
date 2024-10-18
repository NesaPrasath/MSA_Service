package com.example.msa.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.example.msa.Config.Filter.JwtFilter;
import com.example.msa.Config.Service.UserDetailService;
import com.example.msa.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    private final UserRepository urepo;

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception
    {

        return http.csrf(csrf -> csrf
                .disable()).cors(c->c.configurationSource(hp->{
                    CorsConfiguration crcf=new CorsConfiguration();
                    crcf.setAllowedOrigins(List.of("http://localhost:3000/"));
                    crcf.setAllowedMethods(List.of("GET","POST","OPTIONS"));
                    crcf.addAllowedHeader("*");
                    return crcf;
                })).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).
                authorizeHttpRequests((authorize) -> authorize.requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated())
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(new UserDetailService(urepo));
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}
