package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenicastavke;
import com.metropolitan.it355.IT355PZ.services.NarudzbenicastavkeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/narudzbenicastavke")
public class NarudzbenicaStavkeController {
    
    final NarudzbenicastavkeService narudzbenicastavkeService;

    @GetMapping
    public ResponseEntity<List<Narudzbenicastavke>> getNarudzbenicastavke() {
        return ResponseEntity.ok(narudzbenicastavkeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNarudzbenicastavke(@PathVariable Integer id) {
        return ResponseEntity.ok(narudzbenicastavkeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addNarudzbenicastavke(@RequestBody Narudzbenicastavke f) {
        return ResponseEntity.ok(narudzbenicastavkeService.add(f));
    }

    @PutMapping
    public ResponseEntity<?> updateNarudzbenicastavke(@RequestBody Narudzbenicastavke f) {
        return ResponseEntity.ok(narudzbenicastavkeService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNarudzbenicastavke(@PathVariable Integer id) {
        narudzbenicastavkeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
