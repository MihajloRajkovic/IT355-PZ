package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.dto.KorisnikDTO;
import com.metropolitan.it355.IT355PZ.dto.LoginResponse;
import com.metropolitan.it355.IT355PZ.entity.Korisnici;
import com.metropolitan.it355.IT355PZ.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginResponseResponseEntity(@RequestBody KorisnikDTO loginDTO){
        return ResponseEntity.ok(authenticationService.login(loginDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> registerResponseResponseEntity(@RequestBody Korisnici user){
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(value = "Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            authenticationService.logout(token);
            return ResponseEntity.ok(Map.of("message", "Logged out successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid authorization header."));
        }
    }
}
