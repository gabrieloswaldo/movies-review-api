package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.ImdbMovieDTO;
import org.springframework.web.server.ResponseStatusException;

public interface ImdbService {

    ImdbMovieDTO getMovieByTitle(String movieTitle) throws ResponseStatusException;
}
