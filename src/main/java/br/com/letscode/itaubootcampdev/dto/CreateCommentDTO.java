package br.com.letscode.itaubootcampdev.dto;

import br.com.letscode.itaubootcampdev.model.Comment;
import br.com.letscode.itaubootcampdev.model.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
public class CreateCommentDTO {

    @NotBlank
    @Size(max = 20)
    private String movieId;

    @NotNull
    @Size(max = 255)
    private String text;

    public static CreateCommentDTO fromEntity(Comment comment) {
        return CreateCommentDTO.builder()
                .movieId(comment.getMovieId())
                .text(comment.getText())
                .build();
    }

    public static Comment toEntity(CreateCommentDTO commentRequest, User user) {
        return Comment.builder()
                .movieId(commentRequest.getMovieId())
                .text(commentRequest.getText())
                .user(user)
                .build();
    }
}
