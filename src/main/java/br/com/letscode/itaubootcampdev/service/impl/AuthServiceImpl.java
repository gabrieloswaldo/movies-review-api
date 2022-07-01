package br.com.letscode.itaubootcampdev.service.impl;

import br.com.letscode.itaubootcampdev.dto.LoginDTO;
import br.com.letscode.itaubootcampdev.dto.TokenDTO;
import br.com.letscode.itaubootcampdev.model.User;
import br.com.letscode.itaubootcampdev.repository.UserRepository;
import br.com.letscode.itaubootcampdev.service.AuthService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Value("${authentication.api.url}")
    private String authUrl;

    @Value("${authentication.token.secret}")
    private String secret;


    @Override
    public TokenDTO getAuthenticationToken(LoginDTO loginDTO) throws BadCredentialsException {
        HttpEntity<LoginDTO> request = new HttpEntity<>(loginDTO);

        try {
            ResponseEntity<TokenDTO> response = restTemplate.exchange(
                    authUrl, HttpMethod.POST, request, TokenDTO.class);
            return response.getBody();

        } catch (HttpClientErrorException.BadRequest e) {
            throw new BadCredentialsException("Bad credentials!");
        }
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUserFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        BigInteger userId = BigInteger.valueOf(Long.parseLong(claims.getSubject()));
        return userRepository.findById(userId).get();
    }

    @Override
    public User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
