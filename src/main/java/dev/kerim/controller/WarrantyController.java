package dev.kerim.controller;

import dev.kerim.entities.Warranty;
import dev.kerim.service.WarrantyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
@RequiredArgsConstructor
public class WarrantyController {

    private final WarrantyService warrantyService;

    @PostMapping
    public ResponseEntity<Warranty> saveWarranty(@RequestBody Warranty warranty) {
        Warranty savedWarranty = warrantyService.saveWarranty(warranty);
        return ResponseEntity.ok(savedWarranty);
    }

    @PutMapping
    public ResponseEntity<Warranty> updateWarranty(@RequestBody Warranty warranty) {
        Warranty updatedWarranty = warrantyService.updateWarranty(warranty);
        return ResponseEntity.ok(updatedWarranty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarranty(@PathVariable Long id) {
        warrantyService.deleteWarranty(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Warranty>> getAllWarranties() {
        List<Warranty> warranties = warrantyService.getAllWarranties();
        return ResponseEntity.ok(warranties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warranty> getWarrantyById(@PathVariable Long id) {
        Warranty warranty = warrantyService.getWarrantyById(id);
        return ResponseEntity.ok(warranty);
    }
}
