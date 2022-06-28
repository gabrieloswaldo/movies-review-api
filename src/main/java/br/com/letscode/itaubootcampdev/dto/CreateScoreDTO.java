package br.com.letscode.itaubootcampdev.dto;

import br.com.letscode.itaubootcampdev.model.Score;
import br.com.letscode.itaubootcampdev.model.ScorePk;
import br.com.letscode.itaubootcampdev.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CreateScoreDTO {

    @NotBlank
    @Size(max = 20)
    private String movieId;

    @NotNull
    @Max(10)
    @Min(0)
    private Double value;

    // TODO: remove when change to jwt
    private BigInteger userId;

    public static CreateScoreDTO fromEntity(Score scoreCreated) {
        return CreateScoreDTO.builder()
                .movieId(scoreCreated.getId().getMovieId())
                .value(scoreCreated.getValue())
                .build();
    }

    public static Score toEntity(CreateScoreDTO scoreRequest, User user) {
        return Score.builder()
                .id(ScorePk.builder()
                        .movieId(scoreRequest.getMovieId())
                        .user(user)
                        .build())
                .value(scoreRequest.getValue())
                .build();
    }
}
