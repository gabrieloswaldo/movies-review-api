package br.com.letscode.itaubootcampdev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScorePk implements Serializable {

    @NotBlank
    @Size(max = 20)
    private String movieId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
