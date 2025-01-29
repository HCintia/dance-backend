package hu.me.iit.dance.controllers;

import hu.me.iit.dance.dtos.DanceGroupDto;
import hu.me.iit.dance.services.DanceGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class DanceGroupsController {

    private final DanceGroupService danceGroupService;

    @GetMapping("/dance_groups")
    public ResponseEntity<List<DanceGroupDto>> allDanceGroups() {
        return ResponseEntity.ok(danceGroupService.getAllDanceGroups());
    }

    @GetMapping("/dance_groups/{id}")
    public ResponseEntity<DanceGroupDto> getDanceGroup(@PathVariable Long id) {
        return ResponseEntity.ok(danceGroupService.getDanceGroup(id));
    }

    @PostMapping("/dance_groups")
    public ResponseEntity<DanceGroupDto> createDanceGroup(@Valid @RequestBody DanceGroupDto danceGroupDto) {
        DanceGroupDto createdDanceGroup = danceGroupService.createDanceGroup(danceGroupDto);
        return ResponseEntity.created(URI.create("/dance_groups/" + createdDanceGroup.getId())).body(createdDanceGroup);
    }

    @PutMapping("/dance_groups/{id}")
    public ResponseEntity<DanceGroupDto> updateDanceGroup(@PathVariable Long id, @Valid @RequestBody DanceGroupDto danceGroupDto) {
        DanceGroupDto updateDanceGroup = danceGroupService.updateDanceGroup(id, danceGroupDto);
        return ResponseEntity.ok(updateDanceGroup);
    }

    @DeleteMapping("/dance_groups/{id}")
    public ResponseEntity<Void> deleteDanceGroup(@PathVariable Long id) {
        danceGroupService.deleteDanceGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/dance_groups/")
    public ResponseEntity<Void> deleteDanceGroups() {
        danceGroupService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
