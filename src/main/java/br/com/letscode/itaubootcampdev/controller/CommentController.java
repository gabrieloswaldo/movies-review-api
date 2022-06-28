package br.com.letscode.itaubootcampdev.controller;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.model.Comment;
import br.com.letscode.itaubootcampdev.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/comments", produces = APPLICATION_JSON_VALUE)
@Validated
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCommentDTO> create(@RequestBody @Valid CreateCommentDTO commentRequest) {
        Comment commentCreated = commentService.create(commentRequest);
        return ResponseEntity.created(
                URI.create(String.format("/api/v1/comments/%s", commentCreated.getId()))
        ).body(CreateCommentDTO.fromEntity(commentCreated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @NotNull BigInteger commentId) {
        commentService.delete(commentId);
        return ResponseEntity.ok().build();
    }
}
