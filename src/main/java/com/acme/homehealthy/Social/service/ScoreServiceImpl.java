package com.acme.homehealthy.Social.service;

import com.acme.homehealthy.Social.domain.model.Score;
import com.acme.homehealthy.Social.domain.repository.ScoreRepository;
import com.acme.homehealthy.Social.domain.service.ScoreService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Page<Score> getAllScore(Pageable pageable) {
        return scoreRepository.findAll(pageable);
    }

    @Override
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Score","Id",id));
    }

    @Override
    public Score createScore(Score scoreRequest) {
        Score existingName = scoreRepository.findScoreByName(scoreRequest.getName()).orElse(null);
        if(existingName != null){
            throw new ResourceNotFoundException("This name is begin used");
        }

        Score existingValue = scoreRepository.findScoreByValue(scoreRequest.getValue()).orElse(null);
        if(existingValue != null){
            throw new ResourceNotFoundException("This value is begin used");
        }
        return scoreRepository.save(scoreRequest);
    }

    @Override
    public Score updateScore(Long id, Score scoreRequest) {
        Score existingScore = scoreRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Score","Id",id));

        if(existingScore.getName() != scoreRequest.getName()) {
            Score existingName = scoreRepository.findScoreByName(scoreRequest.getName()).orElse(null);
            if (existingName != null) {
                throw new ResourceNotFoundException("This name is begin used");
            }
        }

        if(existingScore.getValue() != scoreRequest.getValue()) {
            Score existingValue = scoreRepository.findScoreByValue(scoreRequest.getValue()).orElse(null);
            if (existingValue != null) {
                throw new ResourceNotFoundException("This value is begin used");
            }
        }
        return scoreRepository.save(
                existingScore.setName(scoreRequest.getName())
                        .setValue(scoreRequest.getValue()));
    }

    @Override
    public ResponseEntity<?> deleteScore(Long id) {
        Score existingScore = scoreRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Score","Id",id));
        scoreRepository.delete(existingScore);
        return ResponseEntity.ok().build();
    }
}
