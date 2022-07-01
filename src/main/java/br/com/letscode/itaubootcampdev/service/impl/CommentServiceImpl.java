package br.com.letscode.itaubootcampdev.service.impl;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.model.Comment;
import br.com.letscode.itaubootcampdev.model.User;
import br.com.letscode.itaubootcampdev.repository.CommentRepository;
import br.com.letscode.itaubootcampdev.repository.UserRepository;
import br.com.letscode.itaubootcampdev.service.AuthService;
import br.com.letscode.itaubootcampdev.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Override
    public Comment create(CreateCommentDTO commentRequest) {
        User authenticatedUser = authService.getAuthenticatedUser();
        return commentRepository.save(CreateCommentDTO.toEntity(commentRequest, authenticatedUser));
    }

    @Override
    public void delete(BigInteger commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Optional<Comment> findById(BigInteger commentId) {
        return commentRepository.findById(commentId);
    }
}
