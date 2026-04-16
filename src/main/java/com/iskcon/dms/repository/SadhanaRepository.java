package com.iskcon.dms.repository;

import com.iskcon.dms.entity.SadhanaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SadhanaRepository extends JpaRepository<SadhanaRecord, Long> {

    SadhanaRecord findByDate(LocalDate date);

    Optional<List<SadhanaRecord>> findByUsername(String username);

    SadhanaRecord findByDateAndUsername(LocalDate date, String username);

    @Query("SELECT s from SadhanaRecord s JOIN User u on s.username = u.username where u.counsellor = :counsellorName ORDER BY s.date desc")
    List<SadhanaRecord> findTeamReport (@Param("counsellorName") String counsellorName);
}
