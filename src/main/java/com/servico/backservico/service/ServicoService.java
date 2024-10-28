package com.servico.backservico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;


    public List<Servico> listar(){
        return servicoRepository.findAll();
    }

    public Servico inserir(Servico servico){
        Servico novoServico = servicoRepository.saveAndFlush(servico);
        return novoServico;
    }

    public Servico alterar(Servico servico){
        Servico novoServico = servicoRepository.saveAndFlush(servico);
        return novoServico;

    }
    
}
