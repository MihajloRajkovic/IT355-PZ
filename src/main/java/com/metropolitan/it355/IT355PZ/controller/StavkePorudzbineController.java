package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Stavkeporudzbine;
import com.metropolitan.it355.IT355PZ.services.StavkeporudzbineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/stavkeporudzbine")
public class StavkePorudzbineController {

    final StavkeporudzbineService stavkeporudzbineService;

    @GetMapping
    public ResponseEntity<List<Stavkeporudzbine>> getPorudzbine() {
        return ResponseEntity.ok(stavkeporudzbineService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorudzbina(@PathVariable Integer id) {
        return ResponseEntity.ok(stavkeporudzbineService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addPorudzbina(@RequestBody Stavkeporudzbine k) {
        return ResponseEntity.ok(stavkeporudzbineService.add(k));
    }

    @PutMapping
    public ResponseEntity<?> updatePorudzbina(@RequestBody Stavkeporudzbine k) {
        return ResponseEntity.ok(stavkeporudzbineService.update(k));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePorudzbina(@PathVariable Integer id) {
        stavkeporudzbineService.delete(id);
        return ResponseEntity.ok().build();
    }
}
