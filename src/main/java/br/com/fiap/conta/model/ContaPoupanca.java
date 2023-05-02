package br.com.fiap.conta.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CONTA_POUPANCA")
@DiscriminatorValue(value = "CP")
public class ContaPoupanca extends Conta {

    private Integer aniversario;

}
