package com.cricket.cricket_score_management.repository;

import com.cricket.cricket_score_management.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}

