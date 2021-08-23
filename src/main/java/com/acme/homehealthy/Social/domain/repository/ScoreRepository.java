package com.acme.homehealthy.Social.domain.repository;

import com.acme.homehealthy.Social.domain.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    Optional<Score> findScoreByValue(Long value);
    Optional<Score> findScoreByName(String name);
}
