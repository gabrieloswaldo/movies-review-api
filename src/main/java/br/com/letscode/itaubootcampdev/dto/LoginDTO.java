package br.com.letscode.itaubootcampdev.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class LoginDTO {

    @NotBlank
    private String email;

    @NotNull
    private String password;
}
