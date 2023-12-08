package com.medninja.sattvagreen.controller;

import com.medninja.sattvagreen.model.HazardRemedies;
import com.medninja.sattvagreen.service.HazardRemediesService;
import com.medninja.sattvagreen.service.HazardRemediesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class HazardRemediesController {
    private final HazardRemediesService hazardRemediesService;

    public HazardRemediesController(HazardRemediesService hazardRemediesService) {
        this.hazardRemediesService = hazardRemediesService;
    }
    @PostMapping("/hazardRemedies")
    public HazardRemedies saveHazardRemedies(@RequestBody HazardRemedies hazardRemedies){
        return hazardRemediesService.saveHazardRemedies(hazardRemedies);
    }
    @GetMapping("/hazardRemedies")
    public List<HazardRemedies> getallHazardRemedies(){
        return hazardRemediesService.getAllHazardRemedies();
    }
    @GetMapping("/hazardRemedies/{remid}")
    public ResponseEntity<HazardRemedies> getHazardRemediesById(@PathVariable("remid") Long remid){
        HazardRemedies hazardRemedies = null;
        hazardRemedies = hazardRemediesService.getHazardRemediesById(remid);
        return ResponseEntity.ok(hazardRemedies);
    }
    @DeleteMapping ("/hazardRemedies/{remid}")
    public ResponseEntity<Map<String,Boolean>> deleteRemedy(@PathVariable("remid") Long remid){
        boolean deleted = false;
        deleted = hazardRemediesService.deleteHazardRemedies(remid);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/hazardRemedies/{remid}")
    public ResponseEntity<HazardRemedies> updateHazardRemedies(@PathVariable("remid") Long remid,@RequestBody HazardRemedies hazardRemedies){
        hazardRemedies = hazardRemediesService.updateHazardRemedies(remid,hazardRemedies);
        return ResponseEntity.ok(hazardRemedies);
    }
}
