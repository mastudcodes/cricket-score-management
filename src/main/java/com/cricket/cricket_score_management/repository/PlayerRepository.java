package com.cricket.cricket_score_management.repository;

import com.cricket.cricket_score_management.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

