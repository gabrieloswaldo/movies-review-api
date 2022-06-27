package br.com.letscode.itaubootcampdev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Comment parentComment;

    @ManyToOne
    @JoinColumn(name = "response_id", nullable = false)
    private Comment responseComment;
}
