package br.com.letscode.itaubootcampdev.repository;

import br.com.letscode.itaubootcampdev.model.Reply;
import br.com.letscode.itaubootcampdev.model.ReplyPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, ReplyPk> {
}
