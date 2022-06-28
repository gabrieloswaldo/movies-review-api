package br.com.letscode.itaubootcampdev.repository;

import br.com.letscode.itaubootcampdev.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CommentRepository extends JpaRepository<Comment, BigInteger> {
}
