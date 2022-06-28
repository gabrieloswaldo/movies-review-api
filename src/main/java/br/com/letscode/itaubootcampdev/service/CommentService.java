package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.model.Comment;

public interface CommentService {

    Comment create(CreateCommentDTO commentRequest);
}
