package com.acme.homehealthy.Social.controller;

import com.acme.homehealthy.Social.domain.model.Score;
import com.acme.homehealthy.Social.domain.service.ScoreService;
import com.acme.homehealthy.Social.resource.SaveComplaintResource;
import com.acme.homehealthy.Social.resource.SaveScoreResource;
import com.acme.homehealthy.Social.resource.ScoreResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "Score", description = "Social API")
@RestController
@RequestMapping("api/")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/scores")
    public Page<ScoreResource> getAllScores(Pageable pageable){
        Page<Score> scores = scoreService.getAllScore(pageable);
        List<ScoreResource> resources = scores.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/scores/{scoreId}")
    public ScoreResource getScoreById(@Valid @PathVariable(name = "scoredId") Long scoredId){
        return convertToResource(scoreService.getScoreById(scoredId));
    }

    @PostMapping("/scores")
    public ScoreResource getScoreById(@Valid @RequestBody SaveScoreResource resource){
        Score score = convertToEntity(resource);
        return convertToResource(scoreService.createScore(score));
    }

    @PutMapping("/score/{scoreId}")
    public ScoreResource updateScoreById(@Valid @PathVariable(name = "scoredId") Long scoredId,
                                         @Valid @RequestBody SaveScoreResource resource){
        Score score = convertToEntity(resource);
        return convertToResource(scoreService.updateScore(scoredId,score));
    }

    @DeleteMapping("/score/{scoreId}")
    public ResponseEntity<?> deleteScoreById(@Valid @PathVariable(name = "scoredId") Long scoredId){
        scoreService.deleteScore(scoredId);
        return ResponseEntity.ok().build();
    }

    private Score convertToEntity(SaveScoreResource resource){return mapper.map(resource,Score.class);}
    private ScoreResource convertToResource(Score score){return mapper.map(score,ScoreResource.class);}
}
