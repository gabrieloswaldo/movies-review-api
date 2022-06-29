package br.com.letscode.itaubootcampdev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "REPLY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply implements Serializable {

    @EmbeddedId
    private ReplyPk id;
}
