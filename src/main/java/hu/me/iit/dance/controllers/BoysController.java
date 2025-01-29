package hu.me.iit.dance.controllers;


import hu.me.iit.dance.dtos.BoyDto;
import hu.me.iit.dance.services.BoysService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoysController {
    private final BoysService boysService;

    @GetMapping("/boys")
    public ResponseEntity<List<BoyDto>> allBoys() {
        return ResponseEntity.ok(boysService.allBoys());
    }

    @GetMapping("/boys/{id}")
    public ResponseEntity<BoyDto> getBoy(@PathVariable Long id) {
        return ResponseEntity.ok(boysService.getBoy(id));
    }

    @PostMapping("/boys")
    public ResponseEntity<BoyDto> createBoy(@Valid @RequestBody BoyDto boyDto) {
        BoyDto createdBoy = boysService.createBoy(boyDto);
        return ResponseEntity.ok(createdBoy);
    }

    @PutMapping("/boys/{id}")
    public ResponseEntity<BoyDto> updateBoy(@PathVariable Long id, @Valid @RequestBody BoyDto boyDto) {
        BoyDto updatedBoy = boysService.updateBoy(id, boyDto);
        return ResponseEntity.ok(updatedBoy);
    }

    @DeleteMapping("/boys/{id}")
    public ResponseEntity<Void> deleteBoy(@PathVariable Long id) {
        boysService.deleteBoy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/boys/")
    public ResponseEntity<Void> deleteBoys() {
        boysService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
