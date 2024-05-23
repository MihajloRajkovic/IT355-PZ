package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.dto.KorisnikDTO;
import com.metropolitan.it355.IT355PZ.dto.LoginResponse;
import com.metropolitan.it355.IT355PZ.entity.Korisnici;

import java.util.Map;

public interface AuthenticationService {
    LoginResponse register(Korisnici request);

    LoginResponse login(KorisnikDTO authenticationRequest);

    void logout(String token);

    Map<String, Object> generateExtraClaims(Korisnici user);

}
