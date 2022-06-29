package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.model.Comment;

import java.math.BigInteger;
import java.util.Optional;

public interface CommentService {

    Comment create(CreateCommentDTO commentRequest);

    void delete(BigInteger commentId);

    Optional<Comment> findById(BigInteger parentCommentId);
}
