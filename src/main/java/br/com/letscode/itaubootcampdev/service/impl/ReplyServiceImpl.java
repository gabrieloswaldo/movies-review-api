package br.com.letscode.itaubootcampdev.service.impl;

import br.com.letscode.itaubootcampdev.dto.CreateCommentDTO;
import br.com.letscode.itaubootcampdev.dto.CreateReplyDTO;
import br.com.letscode.itaubootcampdev.model.Comment;
import br.com.letscode.itaubootcampdev.model.Reply;
import br.com.letscode.itaubootcampdev.repository.ReplyRepository;
import br.com.letscode.itaubootcampdev.service.CommentService;
import br.com.letscode.itaubootcampdev.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private CommentService commentService;

    @Override
    public Reply create(CreateReplyDTO replyRequest) {
        Comment parentComment = commentService.findById(replyRequest.getParentCommentId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent comment invalid!"));

        Comment responseComment = commentService.create(CreateCommentDTO.builder()
                .movieId(replyRequest.getMovieId())
                .text(replyRequest.getText())
                .build());

        return replyRepository.save(CreateReplyDTO.toEntity(parentComment, responseComment));
    }
}
