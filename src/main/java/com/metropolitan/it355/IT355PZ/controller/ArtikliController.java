package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import com.metropolitan.it355.IT355PZ.services.ArtikliService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/artikli")
public class ArtikliController {

    final ArtikliService artikliService;

    @GetMapping
    public ResponseEntity<List<Artikli>> getArtikli() {
        return ResponseEntity.ok(artikliService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKorisnik(@PathVariable Integer id) {
        return ResponseEntity.ok(artikliService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addKorisnik(@RequestBody Artikli k) {
        return ResponseEntity.ok(artikliService.add(k));
    }

    @PutMapping
    public ResponseEntity<?> updateKorisnik(@RequestBody Artikli k) {
        return ResponseEntity.ok(artikliService.update(k));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKorisnik(@PathVariable Integer id) {
        artikliService.delete(id);
        return ResponseEntity.ok().build();
    }


}
