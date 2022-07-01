package br.com.letscode.itaubootcampdev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "USER_ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
