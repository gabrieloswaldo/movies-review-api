package br.com.letscode.itaubootcampdev.controller;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.model.Comment;
import br.com.letscode.itaubootcampdev.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/comments", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CreateCommentDTO> create(@RequestBody @Valid CreateCommentDTO commentRequest) {
        Comment commentCreated = commentService.create(commentRequest);
        return ResponseEntity.created(
                URI.create(String.format("/api/v1/comments/%s", commentCreated.getId()))
        ).body(CreateCommentDTO.fromEntity(commentCreated));
    }
}
