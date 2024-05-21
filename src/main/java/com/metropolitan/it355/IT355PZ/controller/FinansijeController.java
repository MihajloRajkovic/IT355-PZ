package com.metropolitan.it355.IT355PZ.controller;

import com.metropolitan.it355.IT355PZ.entity.Finansije;
import com.metropolitan.it355.IT355PZ.services.FinansijeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/finansije")
public class FinansijeController {

    final FinansijeService finansijeService;

    @GetMapping
    public ResponseEntity<List<Finansije>> getFinansije() {
        return ResponseEntity.ok(finansijeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFinansija(@PathVariable Integer id) {
        return ResponseEntity.ok(finansijeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addFinansija(@RequestBody Finansije f) {
        return ResponseEntity.ok(finansijeService.add(f));
    }

    @PutMapping
    public ResponseEntity<?> updateFinansije(@RequestBody Finansije f) {
        return ResponseEntity.ok(finansijeService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFinansije(@PathVariable Integer id) {
        finansijeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
