package br.com.letscode.itaubootcampdev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TokenDTO {

    private String token;

    private String schema;
}
