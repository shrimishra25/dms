package com.iskcon.dms.service;


import com.iskcon.dms.entity.SadhanaRecord;
import com.iskcon.dms.entity.User;
import com.iskcon.dms.repository.SadhanaRepository;
import com.iskcon.dms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SadhanaService {
    @Autowired
    SadhanaRepository sadhanaRepository;

    public SadhanaRecord saveSadhanaRecord(SadhanaRecord sadhanaRecord) {
        return sadhanaRepository.save(sadhanaRecord);
    }

    public List<SadhanaRecord> fetchData() {
        List<SadhanaRecord> sadhanaRecords = sadhanaRepository
                .findAll(Sort.by(Sort.Direction.DESC, "date"));
        return sadhanaRecords.stream().limit(3).collect(Collectors.toList());
    }

    public SadhanaRecord getDataByDate(LocalDate date, String username) {
        SadhanaRecord recordByDate = sadhanaRepository.findByDateAndUsername(date, username);
        return recordByDate;
    }

    public SadhanaRecord updateSadhanaRecord(SadhanaRecord sadhanaRecord)  {
        String username = sadhanaRecord.getUsername();
        SadhanaRecord recordByDate = sadhanaRepository.findByDate(sadhanaRecord.getDate());

        sadhanaRecord.setDevoteeId(recordByDate.getDevoteeId());
        return sadhanaRepository.save(sadhanaRecord);
    }

    public List<SadhanaRecord> findDataByUsername(String username) throws Exception {
        List<SadhanaRecord> existingSadhanaRecord = sadhanaRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("User not found with id: " + username));
        return existingSadhanaRecord.stream().limit(3).collect(Collectors.toList());
    }

    public List<SadhanaRecord> getRecordsByCounsellor(String counsellorName) {

        List<SadhanaRecord> sadhanaRecords = sadhanaRepository.findTeamReport(counsellorName);

        List<SadhanaRecord> list = sadhanaRecords.stream().collect(Collectors
                        .toMap(a -> a.getUsername(),
                                report -> report,
                                (existing, replacement)
                                        -> existing.getDate().isAfter(replacement.getDate()) ? existing : replacement))
                .values().stream().toList();

        return list;
        //return sadhanaRepository.findTeamReport(counsellorName);
    }
}
