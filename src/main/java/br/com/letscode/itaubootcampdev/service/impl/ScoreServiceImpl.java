package br.com.letscode.itaubootcampdev.service.impl;

import br.com.letscode.itaubootcampdev.dto.CreateScoreDTO;
import br.com.letscode.itaubootcampdev.model.Score;
import br.com.letscode.itaubootcampdev.model.User;
import br.com.letscode.itaubootcampdev.repository.ScoreRepository;
import br.com.letscode.itaubootcampdev.repository.UserRepository;
import br.com.letscode.itaubootcampdev.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Score create(CreateScoreDTO scoreRequest) {
        User user = userRepository.findById(scoreRequest.getUserId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User invalid!")
        );
        return scoreRepository.save(CreateScoreDTO.toEntity(scoreRequest, user));
    }
}
