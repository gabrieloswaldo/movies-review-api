package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.model.Comment;

import java.math.BigInteger;

public interface CommentService {

    Comment create(CreateCommentDTO commentRequest);

    void delete(BigInteger commentId);
}
