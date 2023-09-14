package com.heinz.heinz.model.endereco.service;

import com.heinz.heinz.model.endereco.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public EnderecoDTO cadastrar(String cep){

        var url = "https://viacep.com.br/ws/"+ cep +"/json/";

        EnderecoDTO endereco = restTemplate.getForObject(url, EnderecoDTO.class);

        return endereco;
    }

}
