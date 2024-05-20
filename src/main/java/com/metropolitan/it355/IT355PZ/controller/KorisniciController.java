package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Korisnici;
import com.metropolitan.it355.IT355PZ.services.KorisniciService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/korisnici")
public class KorisniciController {

    final KorisniciService korisniciService;

    @GetMapping
    public ResponseEntity<List<Korisnici>> getKorisnici() {
        return ResponseEntity.ok(korisniciService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKorisnik(@PathVariable Integer id) {
        return ResponseEntity.ok(korisniciService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addKorisnik(@RequestBody Korisnici k) {
        return ResponseEntity.ok(korisniciService.add(k));
    }

    @PutMapping
    public ResponseEntity<?> updateKorisnik(@RequestBody Korisnici k) {
        return ResponseEntity.ok(korisniciService.update(k));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKorisnik(@PathVariable Integer id) {
        korisniciService.delete(id);
        return ResponseEntity.ok().build();
    }


}
