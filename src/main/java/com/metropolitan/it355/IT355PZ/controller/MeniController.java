package com.metropolitan.it355.IT355PZ.controller;


import com.metropolitan.it355.IT355PZ.entity.Meni;
import com.metropolitan.it355.IT355PZ.services.MeniService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/meni")
public class MeniController {

    final MeniService meniService;

    @GetMapping
    public ResponseEntity<List<Meni>> getMeni() {
        return ResponseEntity.ok(meniService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMeni(@PathVariable Integer id) {
        return ResponseEntity.ok(meniService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addMeni(@RequestBody Meni f) {
        return ResponseEntity.ok(meniService.add(f));
    }

    @PutMapping
    public ResponseEntity<?> updateMeni(@RequestBody Meni f) {
        return ResponseEntity.ok(meniService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeni(@PathVariable Integer id) {
        meniService.delete(id);
        return ResponseEntity.ok().build();
    }
}
