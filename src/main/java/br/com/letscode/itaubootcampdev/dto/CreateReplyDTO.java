package br.com.letscode.itaubootcampdev.dto;

import br.com.letscode.itaubootcampdev.model.Comment;
import br.com.letscode.itaubootcampdev.model.Reply;
import br.com.letscode.itaubootcampdev.model.ReplyPk;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Getter
@Builder
public class CreateReplyDTO {

    @NotBlank
    @Size(max = 20)
    private String movieId;

    @NotNull
    private BigInteger parentCommentId;

    @NotNull
    @Size(max = 255)
    private String text;

    // TODO: remove when change to jwt
    private BigInteger userId;

    public static CreateReplyDTO fromEntity(Reply reply) {
        return CreateReplyDTO.builder()
                .movieId(reply.getId().getResponseComment().getMovieId())
                .parentCommentId(reply.getId().getParentComment().getId())
                .text(reply.getId().getResponseComment().getText())
                .build();
    }

    public static Reply toEntity(Comment parentComment, Comment responseComment) {
        return Reply.builder()
                .id(ReplyPk.builder()
                        .parentComment(parentComment)
                        .responseComment(responseComment)
                        .build())
                .build();
    }
}
