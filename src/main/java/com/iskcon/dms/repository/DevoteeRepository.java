package com.iskcon.dms.repository;

import com.iskcon.dms.entity.Devotee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevoteeRepository extends JpaRepository<Devotee, Integer> {

    Devotee findByName(String name);

    //List<Devotee> listOfPeople = findByIdIn(List<Integer> num);

    //List<Devotee> fetchByChantingRound(int round);
}
