package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CONTA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TP_CONTA")
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTA")
    @SequenceGenerator(name = "SQ_CONTA", sequenceName = "SQ_CONTA")
    @Column(name = "ID_CONTA")
    private Long id;
    @Column(name = "NR_CONTA")
    private Integer numero;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_AGENCIA",
            referencedColumnName = "ID_AGENCIA",
            foreignKey = @ForeignKey(name = "FK_CONTA_AGENCIA")
    )
    @Column(name = )
    private Agencia agencia;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_TITULAR_CONTA",
            joinColumns = {
                    @JoinColumn(
                            name = "ID_CONTA",
                            referencedColumnName = "ID_CONTA",
                    foreignKey = @ForeignKey(name = "FK_CONTA")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_PESSOA",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(name = "FK_TITULAR")
                    )
            }
    )
    private Set<Pessoa>  titulares = new LinkedHashSet<>();

    public Conta addTitular(Pessoa p){
        this.titulares.add(p);
        return this;
    }
    public Conta removeTitular(Pessoa p) {
        this.titulares.remove(p);
        return this;
    }

    @Setter
    @Getter
    private double saldo;



}
