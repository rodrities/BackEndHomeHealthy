package com.acme.homehealthy.Social.domain.service;

import com.acme.homehealthy.Social.domain.model.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ScoreService {
    Page<Score> getAllScore(Pageable pageable);
    Score getScoreById(Long id);
    Score createScore(Score scoreRequest);
    Score updateScore(Long id, Score scoreRequest);
    ResponseEntity<?> deleteScore(Long id);
}
