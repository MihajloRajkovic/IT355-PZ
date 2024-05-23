package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.dto.KorisnikDTO;
import com.metropolitan.it355.IT355PZ.dto.LoginResponse;
import com.metropolitan.it355.IT355PZ.entity.Korisnici;
import com.metropolitan.it355.IT355PZ.jwt.JwtService;
import com.metropolitan.it355.IT355PZ.providers.UserProvider;
import com.metropolitan.it355.IT355PZ.repository.KorisniciRepository;
import com.metropolitan.it355.IT355PZ.services.AuthenticationService;
import com.metropolitan.it355.IT355PZ.services.KorisniciService;
import com.metropolitan.it355.IT355PZ.services.TokenBlackListService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final KorisniciRepository userRepository;
    private final JwtService jwtService;
    private final TokenBlackListService tokenBlackListService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public LoginResponse register(Korisnici request) {
        var user = new Korisnici();
        user.setIme(request.getIme());
        user.setPrezime(request.getPrezime());
        user.setKorisnickoIme(request.getKorisnickoIme());
        user.setLozinka(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user, generateExtraClaims(user));
        return  new LoginResponse(token);
    }

    @Override
    public LoginResponse login(KorisnikDTO authenticationRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(authToken);
        Korisnici user = userRepository.findByKorisnickoIme(authenticationRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return new LoginResponse(jwt);
    }

    @Override
    public void logout(String token) {
        tokenBlackListService.blacklistToken(token);
        SecurityContextHolder.clearContext();

    }

    @Override
    public Map<String, Object> generateExtraClaims(Korisnici user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("ID_Korisnika" , user.getId());
        extraClaims.put("Ime" , user.getIme());
        extraClaims.put("Prezime" , user.getPrezime());
        extraClaims.put("Korisnicko_Ime" , user.getKorisnickoIme());
        extraClaims.put("Tip_Korisnika" , user.getTipKorisnika());
        extraClaims.put("Role" , user.getRole());
        return extraClaims;
    }
}
