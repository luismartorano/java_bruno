package br.com.bruno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, message = "O nome do material precisa ser válido.")
    private String nome;
    private BigInteger lote;

    private float preco;
    private LocalDate validade;
    private Integer quantidade_total;

    @Override
    public String toString() {
        return nome;
    }
      
}

