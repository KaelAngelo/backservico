package com.servico.backservico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servico.backservico.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
    

    @Query("select s from Servico s where s.status = 'Pendente'")
    List<Servico> buscarServicosPagamentoPendente();

    @Query("select s from Servico s where s.status = 'Cancelado'")
    List<Servico> buscarServicosCancelados();

    @Query("select s from Servico s where s.status = 'Realizado'")
    List<Servico> buscarServicosRealizado();
}
