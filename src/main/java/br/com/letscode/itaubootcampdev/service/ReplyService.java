package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.CreateReplyDTO;
import br.com.letscode.itaubootcampdev.model.Reply;

public interface ReplyService {

    Reply create(CreateReplyDTO replyRequest);
}
