package br.com.swagger.crud_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository; // Precisamos dele para associar

    // ATENÇÃO: Para criar um Documento, não recebemos o objeto inteiro.
    // Usamos um "DTO" (DocumentoRequest) para simplificar.
    @PostMapping
    public ResponseEntity<Documento> create(@RequestBody DocumentoRequest docRequest) {
        
        // Tenta encontrar a categoria pelo ID
        return categoriaRepository.findById(docRequest.getCategoriaId())
                .map(categoria -> { // Se encontrou a categoria...
                    Documento doc = new Documento();
                    doc.setTitulo(docRequest.getTitulo());
                    doc.setConteudo(docRequest.getConteudo());
                    doc.setCategoria(categoria); // ...associa ela ao novo documento
                    
                    Documento docSalvo = documentoRepository.save(doc);
                    return ResponseEntity.ok(docSalvo);
                })
                // Se não encontrou a categoria, retorna 400 Bad Request
                .orElse(ResponseEntity.badRequest().build()); 
    }

    @GetMapping
    public List<Documento> getAll() {
        return documentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> getById(@PathVariable Long id) {
        return documentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // (Opcional: Implementar PUT e DELETE de Documento)

    
    // Esta é uma classe "interna" que serve como DTO.
    // Ela define como o JSON de "criação de documento" deve ser.
    @Getter
    @Setter
    public static class DocumentoRequest {
        private String titulo;
        private String conteudo;
        private Long categoriaId; // No JSON, vamos passar só o ID da categoria
    }
}