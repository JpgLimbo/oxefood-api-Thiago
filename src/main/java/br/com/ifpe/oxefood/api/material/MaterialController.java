package br.com.ifpe.oxefood.api.material;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.material.Material;
import br.com.ifpe.oxefood.modelo.material.MaterialService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/material")
public class MaterialController extends GenericController {

   @Autowired
   private MaterialService materialService;

   @PostMapping
   public ResponseEntity<Material> save(@RequestBody @Valid MaterialRequest request) {

       Material material = materialService.save(request.build());
       return new ResponseEntity<Material>(material, HttpStatus.CREATED);
   }
   
   @GetMapping
   public List<Material> listarTodos() {
  
       return materialService.listarTodos();
   }

   @GetMapping("/{id}")
   public Material obterPorID(@PathVariable Long id) {

       return materialService.obterPorID(id);
   }
   @PutMapping("/{id}")
   public ResponseEntity<Material> update(@PathVariable("id") Long id, @RequestBody MaterialRequest request) {

       materialService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       materialService.delete(id);
       return ResponseEntity.ok().build();
   }
}
