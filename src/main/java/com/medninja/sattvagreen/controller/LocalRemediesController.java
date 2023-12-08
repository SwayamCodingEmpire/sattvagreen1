package com.medninja.sattvagreen.controller;

import com.medninja.sattvagreen.model.LocalRemedies;
import com.medninja.sattvagreen.service.LocalRemediesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LocalRemediesController {
    private final LocalRemediesService localRemediesService;

    public LocalRemediesController(LocalRemediesService localRemediesService) {
        this.localRemediesService = localRemediesService;
    }
    @PostMapping("/localremedies")
    public LocalRemedies saveLocalRemedies(@RequestBody LocalRemedies localRemedies){
        return localRemediesService.saveLocalRemedies(localRemedies);
    }
    @GetMapping("/localremedies")
    public List<LocalRemedies> getallLocalRemedies(){
        return localRemediesService.getAllLocalRemedies();
    }
    @GetMapping("/localremedies/{remid}")
    public ResponseEntity<LocalRemedies> getLocalRemediesById(@PathVariable("remid") Long remid){
        LocalRemedies localRemedies = null;
        localRemedies = localRemediesService.getLocalRemediesById(remid);
        return ResponseEntity.ok(localRemedies);
    }
    @DeleteMapping ("/localremedies/{remid}")
    public ResponseEntity<Map<String,Boolean>> deleteRemedy(@PathVariable("remid") Long remid){
        boolean deleted = false;
        deleted = localRemediesService.deleteLocalRemedies(remid);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/localremedies/{remid}")
    public ResponseEntity<LocalRemedies> updateLocalRemedies(@PathVariable("remid") Long remid,@RequestBody LocalRemedies localRemedies){
        localRemedies = localRemediesService.updateLocalRemedies(remid,localRemedies);
        return ResponseEntity.ok(localRemedies);
    }
}
