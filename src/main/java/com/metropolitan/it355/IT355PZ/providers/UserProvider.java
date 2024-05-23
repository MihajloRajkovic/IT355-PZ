package com.metropolitan.it355.IT355PZ.providers;

import com.metropolitan.it355.IT355PZ.repository.KorisniciRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserProvider {

    private final KorisniciRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            return userRepository.findByKorisnickoIme(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        };
    }
}
