package com.iskcon.dms.controller;


import com.iskcon.dms.entity.SadhanaRecord;
import com.iskcon.dms.service.SadhanaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sadhana")
//@CrossOrigin(origins = "http://localhost:5173")
public class SadhanaController {

    Logger logger = LoggerFactory.getLogger(SadhanaController.class);

    @Autowired
    private SadhanaService sadhanaService;

    @PostMapping("/save")
    public ResponseEntity<SadhanaRecord> saveRecord(@RequestBody SadhanaRecord sadhanaRecord) {
        logger.info("Request:{}", sadhanaRecord);
        return new ResponseEntity<>(sadhanaService.saveSadhanaRecord(sadhanaRecord), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SadhanaRecord>> getAllRecords() {
        // Returns all records sorted by date descending
        return new ResponseEntity<>(sadhanaService.fetchData(), HttpStatus.OK);
    }

    @GetMapping("/sadhak")
    public ResponseEntity<List<SadhanaRecord>> getRecord(@RequestParam String username) throws Exception {
        // Returns all records sorted by date descending
        return new ResponseEntity<>(sadhanaService.findDataByUsername(username), HttpStatus.OK);
    }

    // fetch data by Date and Username
    @GetMapping("/byDate")
    public ResponseEntity<SadhanaRecord> getRecord(@RequestParam LocalDate date, @RequestParam String username) {
        // Returns single record matched by date
        return new ResponseEntity<>(sadhanaService.getDataByDate(date, username), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SadhanaRecord> updateRecord(@RequestBody SadhanaRecord sadhanaRecord) {
        // Returns single record matched by date
        return new ResponseEntity<>(sadhanaService.updateSadhanaRecord(sadhanaRecord), HttpStatus.OK);
    }

    @GetMapping("/counsellor/report")
    public ResponseEntity<List<SadhanaRecord>> getCounsellorReport(@RequestParam String counsellorName) {
        List<SadhanaRecord> reports = sadhanaService.getRecordsByCounsellor(counsellorName);
        return ResponseEntity.ok(reports);
    }
}
