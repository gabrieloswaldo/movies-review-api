package br.com.letscode.itaubootcampdev.controller;

import br.com.letscode.itaubootcampdev.dto.CreateReplyDTO;
import br.com.letscode.itaubootcampdev.model.Reply;
import br.com.letscode.itaubootcampdev.service.ReplyService;
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
@RequestMapping(value = "/api/v1/replies", produces = APPLICATION_JSON_VALUE)
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateReplyDTO> create(@RequestBody @Valid CreateReplyDTO replyRequest) {
        Reply replyCreated = replyService.create(replyRequest);
        return ResponseEntity.created(
                URI.create(String.format("/api/v1/replies/%s/%s", replyCreated.getId().getParentComment().getId(),
                        replyCreated.getId().getResponseComment().getId()))
        ).body(CreateReplyDTO.fromEntity(replyCreated));
    }
}
