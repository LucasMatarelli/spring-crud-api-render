package br.com.swagger.crud_api;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository<NomeDaEntidade, TipoDoId>
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}