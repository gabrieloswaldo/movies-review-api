package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.CreateScoreDTO;
import br.com.letscode.itaubootcampdev.model.Score;

public interface ScoreService {

    Score create(CreateScoreDTO scoreRequest);
}
