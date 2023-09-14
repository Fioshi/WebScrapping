package com.heinz.heinz.model.empresa;

import com.heinz.heinz.model.endereco.Endereco;
import com.heinz.heinz.model.endereco.EnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_empresa")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEmpresa;

    private String sedeEmpresa;

    private String cnpjEmpresa;

    private Endereco endereco;

    public Empresa(EmpresaDTO dto, EnderecoDTO enderecoDTO) {
        this.nomeEmpresa = dto.nomeEmpresa();
        this.sedeEmpresa = dto.sedeEmpresa();
        this.cnpjEmpresa = dto.cnpjEmpresa();
        this.endereco = new Endereco(enderecoDTO);
    }
}
