package br.com.letscode.itaubootcampdev.controller;

import br.com.letscode.itaubootcampdev.dto.CreateScoreDTO;
import br.com.letscode.itaubootcampdev.model.Score;
import br.com.letscode.itaubootcampdev.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/scores", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<CreateScoreDTO> create(@RequestBody @Valid CreateScoreDTO scoreRequest) {
        Score scoreCreated = scoreService.create(scoreRequest);
        return ResponseEntity.created(
                URI.create(String.format("/api/v1/scores/%s", scoreCreated.getId().getMovieId()))
        ).body(CreateScoreDTO.fromEntity(scoreCreated));
    }
}
