package br.com.swagger.crud_api;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository<NomeDaEntidade, TipoDoId>
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}