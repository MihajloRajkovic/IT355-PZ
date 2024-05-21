package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Menistavke;
import com.metropolitan.it355.IT355PZ.services.MenistavkeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menistavke")
public class MeniStavkeController {

    final MenistavkeService menistavkeService;

    @GetMapping
    public ResponseEntity<List<Menistavke>> getMenistavke() {
        return ResponseEntity.ok(menistavkeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMenistavke(@PathVariable Integer id) {
        return ResponseEntity.ok(menistavkeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addMenistavke(@RequestBody Menistavke f) {
        return ResponseEntity.ok(menistavkeService.add(f));
    }

    @PutMapping
    public ResponseEntity<?> updateMenistavke(@RequestBody Menistavke f) {
        return ResponseEntity.ok(menistavkeService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenistavke(@PathVariable Integer id) {
        menistavkeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
