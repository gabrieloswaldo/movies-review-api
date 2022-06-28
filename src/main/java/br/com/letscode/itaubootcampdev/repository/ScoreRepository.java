package br.com.letscode.itaubootcampdev.repository;

import br.com.letscode.itaubootcampdev.model.Score;
import br.com.letscode.itaubootcampdev.model.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
