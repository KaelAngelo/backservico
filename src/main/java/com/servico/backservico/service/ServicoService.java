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


    public List<Servico> buscarTodos(){
        return servicoRepository.findAll();
    }

    public List<Servico> buscarServicoPagamentoPendente(){
        return servicoRepository.buscarServicosPagamentoPendente();
    }

    public List<Servico> buscarServicoCancelado(){
        return servicoRepository.buscarServicosCancelados();
    }

    public List<Servico> buscarServicoRealizado(){
        return servicoRepository.buscarServicosRealizado();
    }

    public Servico inserir(Servico servico){
       
        if(servico.getValorPago()==null || servico.getValorPago()==0 || servico.getDataPagamento()==null){
            servico.setStatus("Pendente");
        }else           
            servico.setStatus("Realizado");         

        Servico novoServico = servicoRepository.saveAndFlush(servico);
        return novoServico;
    }

    public Servico alterar(Servico servico){
        if(servico.getValorPago()!=null && servico.getValorPago()>0 && servico.getDataPagamento()!=null){
            servico.setStatus("Realizado");
        }                     
        return servicoRepository.saveAndFlush(servico);        
    }

    public void excluir(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servicoRepository.delete(servico);
    }

    public void cancelarServico(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servico.setStatus("Cancelado");
        servicoRepository.saveAndFlush(servico);
    }
    
}
