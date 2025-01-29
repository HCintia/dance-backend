package hu.me.iit.dance.controllers;

import hu.me.iit.dance.dtos.GirlDto;
import hu.me.iit.dance.services.GirlsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class GirlsController {

    private final GirlsService girlsService;

    @GetMapping("/girls")
    public ResponseEntity<List<GirlDto>> allGirls() {
        return ResponseEntity.ok(girlsService.allGirls());
    }

    @GetMapping("/girls/{id}")
    public ResponseEntity<GirlDto> getGirl(@PathVariable Long id) {
        return ResponseEntity.ok(girlsService.getGirl(id));
    }

    @PostMapping("/girls")
    public ResponseEntity<GirlDto> createGirl(@Valid @RequestBody GirlDto girlDto) {
        GirlDto createdGirl = girlsService.createGirl(girlDto);
        return ResponseEntity.created(URI.create("/girls/" + createdGirl.getId())).body(createdGirl);
    }

    @PutMapping("/girls/{id}")
    public ResponseEntity<GirlDto> updateGirl(@PathVariable Long id, @Valid @RequestBody GirlDto girlDto) {
        GirlDto updatedGirl = girlsService.updateGirl(id, girlDto);
        return ResponseEntity.ok(updatedGirl);
    }

    @DeleteMapping("/girls/{id}")
    public ResponseEntity<Void> deleteGirl(@PathVariable Long id) {
        girlsService.deleteGirl(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/girls/")
    public ResponseEntity<Void> deleteGirls() {
        girlsService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
