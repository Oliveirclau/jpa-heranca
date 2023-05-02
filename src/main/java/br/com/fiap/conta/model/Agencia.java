package br.com.fiap.conta.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_AGENCIA")

public class Agencia {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "SQ_AGENCIA",)
    private Long id;
    private Integer numero;

}
