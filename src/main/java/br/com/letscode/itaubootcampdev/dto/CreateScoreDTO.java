package br.com.letscode.itaubootcampdev.dto;

import br.com.letscode.itaubootcampdev.model.Score;
import br.com.letscode.itaubootcampdev.model.ScorePk;
import br.com.letscode.itaubootcampdev.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

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

    public static CreateScoreDTO fromEntity(Score scoreEntity) {
        return CreateScoreDTO.builder()
                .movieId(scoreEntity.getId().getMovieId())
                .value(scoreEntity.getValue())
                .build();
    }

    public static Score toEntity(CreateScoreDTO scoreDTO, User user) {
        return Score.builder()
                .id(ScorePk.builder()
                        .movieId(scoreDTO.getMovieId())
                        .user(user)
                        .build())
                .value(scoreDTO.getValue())
                .build();
    }
}
