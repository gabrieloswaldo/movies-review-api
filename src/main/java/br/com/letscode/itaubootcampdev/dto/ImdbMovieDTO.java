package br.com.letscode.itaubootcampdev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ImdbMovieDTO implements Serializable {

    private String imdbID;
    private String Title;
    private String Year;
    private String Runtime;
    private String Genre;
    private String Actors;

}
