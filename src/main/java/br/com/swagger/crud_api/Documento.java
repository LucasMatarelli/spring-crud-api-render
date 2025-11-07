package br.com.swagger.crud_api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference; // ⬅️ IMPORT ADICIONADO

@Entity
@Getter
@Setter
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String conteudo;

    // Relacionamento: Muitos Documentos para Uma Categoria
    @JsonBackReference // ⬅️ ANOTAÇÃO ADICIONADA
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}