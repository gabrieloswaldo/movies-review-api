package br.com.letscode.itaubootcampdev.repository;

import br.com.letscode.itaubootcampdev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {
}
