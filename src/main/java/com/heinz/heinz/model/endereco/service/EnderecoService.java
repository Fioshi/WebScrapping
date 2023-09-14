package com.heinz.heinz.model.endereco.service;

import com.heinz.heinz.model.endereco.Endereco;
import com.heinz.heinz.model.endereco.EnderecoDTO;
import com.heinz.heinz.model.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {


    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco cadastrar(String cep){

        var url = "https://viacep.com.br/ws/"+ cep +"/json/";

        EnderecoDTO enderecoDTO = restTemplate.getForObject(url, EnderecoDTO.class);
        Endereco endereco = new Endereco(enderecoDTO);

        enderecoRepository.save(endereco);

        return endereco;
    }

}
