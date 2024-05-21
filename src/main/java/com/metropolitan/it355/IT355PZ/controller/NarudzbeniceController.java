package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenice;
import com.metropolitan.it355.IT355PZ.services.NarudzbeniceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/narudzbenice")
public class NarudzbeniceController {

    final NarudzbeniceService narudzbeniceService;

    @GetMapping
    public ResponseEntity<List<Narudzbenice>> getNarudzbenice() {
        return ResponseEntity.ok(narudzbeniceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNarudzbenica(@PathVariable Integer id) {
        return ResponseEntity.ok(narudzbeniceService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addNarudzbenica(@RequestBody Narudzbenice k) {
        return ResponseEntity.ok(narudzbeniceService.add(k));
    }

    @PutMapping
    public ResponseEntity<?> updateNarudzbenica(@RequestBody Narudzbenice k) {
        return ResponseEntity.ok(narudzbeniceService.update(k));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletenarudzbenica(@PathVariable Integer id) {
        narudzbeniceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
