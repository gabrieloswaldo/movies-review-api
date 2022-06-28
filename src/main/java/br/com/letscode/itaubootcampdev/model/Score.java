package br.com.letscode.itaubootcampdev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "SCORE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Score implements Serializable {

    @EmbeddedId
    private ScorePk id;

    @NotNull
    @Column(name = "value_")
    private Double value;
}
