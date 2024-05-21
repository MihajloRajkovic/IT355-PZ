package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Porudzbine;
import com.metropolitan.it355.IT355PZ.services.PorudzbineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/porudzbine")
public class PorudzbineController {

    final PorudzbineService porudzbineService;

    @GetMapping
    public ResponseEntity<List<Porudzbine>> getPorudzbine() {
        return ResponseEntity.ok(porudzbineService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorudzbina(@PathVariable Integer id) {
        return ResponseEntity.ok(porudzbineService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addPorudzbina(@RequestBody Porudzbine k) {
        return ResponseEntity.ok(porudzbineService.add(k));
    }

    @PutMapping
    public ResponseEntity<?> updatePorudzbina(@RequestBody Porudzbine k) {
        return ResponseEntity.ok(porudzbineService.update(k));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePorudzbina(@PathVariable Integer id) {
        porudzbineService.delete(id);
        return ResponseEntity.ok().build();
    }
}
