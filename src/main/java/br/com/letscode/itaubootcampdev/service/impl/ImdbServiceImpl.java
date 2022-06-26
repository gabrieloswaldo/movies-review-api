package br.com.letscode.itaubootcampdev.service.impl;

import br.com.letscode.itaubootcampdev.dto.ImdbMovieDTO;
import br.com.letscode.itaubootcampdev.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ImdbServiceImpl implements ImdbService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${imdb-api.key}")
    private String apiKey;

    @Value("${imdb-api.url}")
    private String baseUrl;

    @Override
    public ImdbMovieDTO getMovieByTitle(String movieTitle) throws ResponseStatusException {
        ImdbMovieDTO imdbMovie = restTemplate.getForObject(buildUrl(movieTitle), ImdbMovieDTO.class);
        if (imdbMovie == null || imdbMovie.getImdbID() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found!");
        }
        return imdbMovie;
    }

    private String buildUrl(String movieTitle) {
        final String TITLE_PARAM = "&t=";
        return baseUrl + apiKey + TITLE_PARAM + movieTitle.replace(" ", "+");
    }

}
