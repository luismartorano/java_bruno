package br.com.bruno.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min = 1, message = "O login precisa ser válido.")
    @Column(unique = true)
    private String login;
    private String senha;
    private String papel;

    public void setSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.senha = encoder.encode(senha);
        
    }

}
