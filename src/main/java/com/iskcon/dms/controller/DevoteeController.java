package com.iskcon.dms.controller;

import com.iskcon.dms.entity.Devotee;
import com.iskcon.dms.entity.SpiritualDetail;
import com.iskcon.dms.service.DevoteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bsl")
public class DevoteeController {

    @Autowired
    private DevoteeService devoteeService;

    // it fetches list of all devotees available in db
    @GetMapping("/devotees")
    public ResponseEntity<List<Devotee>> getDevotees() {
        return new ResponseEntity<>(devoteeService.getDevotee(), HttpStatus.OK);
    }

    @GetMapping("/devotee")
    public Devotee getDevoteeByName(@RequestParam String name) {
        return devoteeService.findDevoteeByName(name);
    }

    @PostMapping("/add")
    public Devotee addDevotee(@RequestBody Devotee devotee) {
        return devoteeService.addDevotee(devotee);
    }

    @GetMapping("/chanting/{round}")
    public ResponseEntity<List<String>> chantDevotee(@PathVariable int round) {

        List<String> devoteesChanting =
                devoteeService.fetchByChantingRounds(round);
        if(!devoteesChanting.isEmpty()){
            return new ResponseEntity<>(devoteesChanting, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/spiritualDetails/{spiritualId}")
    public ResponseEntity<List<SpiritualDetail>> fetchById(@PathVariable int spiritualId) {
        List<SpiritualDetail> spiritualDetails =
                devoteeService.fetchById(spiritualId);
        if(!spiritualDetails.isEmpty()){
            return new ResponseEntity<>(spiritualDetails, HttpStatus.FOUND);
        } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
