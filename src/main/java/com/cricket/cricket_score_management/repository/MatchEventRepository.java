package com.cricket.cricket_score_management.repository;

import com.cricket.cricket_score_management.entity.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchEventRepository extends JpaRepository<MatchEvent, Long> {

    List<MatchEvent> findByMatchId(Long matchId);
}
