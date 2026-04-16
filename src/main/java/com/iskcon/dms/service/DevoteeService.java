package com.iskcon.dms.service;

import com.iskcon.dms.entity.Devotee;
import com.iskcon.dms.entity.SpiritualDetail;
import com.iskcon.dms.repository.DevoteeRepository;
import com.iskcon.dms.repository.SpiritualDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DevoteeService {

    @Autowired
    private DevoteeRepository devoteeRepository;

    @Autowired
    private SpiritualDetailsRepository spiritualDetailsRepository;

    public List<Devotee> getDevotee() {
        return devoteeRepository.findAll();
    }

    public Devotee findDevoteeByName(String name) {
        return devoteeRepository.findByName(name);
    }

    public Devotee addDevotee(Devotee devotee) {
        return devoteeRepository.save(devotee);
    }

    public List<String> fetchByChantingRounds(int round) {
     List<SpiritualDetail> listOfPeople =
             spiritualDetailsRepository.findByChantingRound(round);

        List<Integer> listOfIdChanting = listOfPeople.stream()
                .map(a -> a.getDevoteeId()).distinct().toList();

        return devoteeRepository.findAllById(listOfIdChanting).
                stream().map(e -> e.getName()).toList();
    }

    public List<SpiritualDetail> fetchById(int spiritualId) {

        return spiritualDetailsRepository.findAll();
    }
}
