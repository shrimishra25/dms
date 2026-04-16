package com.iskcon.dms.repository;

import com.iskcon.dms.entity.SpiritualDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpiritualDetailsRepository extends JpaRepository<SpiritualDetail,Integer> {

    List<SpiritualDetail> findByChantingRound(int round);
}
