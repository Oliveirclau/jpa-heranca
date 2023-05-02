package br.com.fiap.conta.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CONTA_CORRENTE")
@DiscriminatorValue(value = "CC")

public abstract class ContaCorrente extends Conta {
    private double limite;

}
