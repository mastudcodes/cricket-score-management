package com.cricket.cricket_score_management.repository;

import com.cricket.cricket_score_management.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
