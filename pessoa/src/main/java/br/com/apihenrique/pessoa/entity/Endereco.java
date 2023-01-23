package br.com.apihenrique.pessoa.entity;

import java.io.Serializable;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Utilizando Lombok para manter o código mais limpo
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "favorito", nullable = false)
    private Boolean favorito;


    //Coluna da relação entre pessoa e endereço
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pessoa", nullable = false)
    private Pessoa pessoa;

}
