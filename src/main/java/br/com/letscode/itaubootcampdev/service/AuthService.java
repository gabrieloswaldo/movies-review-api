package br.com.letscode.itaubootcampdev.service;

import br.com.letscode.itaubootcampdev.dto.LoginDTO;
import br.com.letscode.itaubootcampdev.dto.TokenDTO;
import br.com.letscode.itaubootcampdev.model.User;
import org.springframework.security.authentication.BadCredentialsException;

public interface AuthService {

    TokenDTO getAuthenticationToken(LoginDTO loginDTO) throws BadCredentialsException;

    boolean isTokenValid(String token);

    User getUserFromToken(String token);
}
