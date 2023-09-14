package com.heinz.heinz.model.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "tb_endereco")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String localidade;

    private String numero;

    public Endereco (EnderecoDTO dto){
        this.logradouro = dto.logradouro();
        this.bairro = dto.bairro();
        this.localidade = dto.localidade();
        this.numero = dto.numero();
    }
}
