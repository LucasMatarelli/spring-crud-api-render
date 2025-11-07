package br.com.swagger.crud_api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference; // ⬅️ IMPORT ADICIONADO

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento: Uma Categoria pode ter muitos Documentos
    @JsonManagedReference // ⬅️ ANOTAÇÃO ADICIONADA
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Set<Documento> documentos;
}