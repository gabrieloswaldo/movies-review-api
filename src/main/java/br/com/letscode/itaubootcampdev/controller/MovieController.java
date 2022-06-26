package br.com.letscode.itaubootcampdev.controller;

import br.com.letscode.itaubootcampdev.dto.ImdbMovieDTO;
import br.com.letscode.itaubootcampdev.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/movies", produces = APPLICATION_JSON_VALUE)
public class MovieController {

    @Autowired
    private ImdbService imdbService;

    @GetMapping
    public ResponseEntity<ImdbMovieDTO> getMovieByTitle(
            @RequestParam(name = "title") String movieTitle) {
        ImdbMovieDTO imdbMovie = imdbService.getMovieByTitle(movieTitle);
        return ResponseEntity.ok(imdbMovie);
    }
}
