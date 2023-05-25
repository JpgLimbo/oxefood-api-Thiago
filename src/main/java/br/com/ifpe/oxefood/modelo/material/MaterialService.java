package br.com.ifpe.oxefood.modelo.material;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class MaterialService extends GenericService {

   @Autowired
   private MaterialRepository repository;

   @Transactional
   public Material save(Material material) {

       super.preencherCamposAuditoria(material);
       return repository.save(material);
    }
    @Transactional
   public void update(Long id, Material materialAlterado) {

      Material material = repository.findById(id).get();
      material.setTitulo(materialAlterado.getTitulo());
      material.setValor(materialAlterado.getValor());
      material.setResponsavel(materialAlterado.getResponsavel());
      material.setLocalizacao(materialAlterado.getLocalizacao());
      material.setPeso(materialAlterado.getPeso());
      material.setDataAquisicao(materialAlterado.getDataAquisicao());
      
      super.preencherCamposAuditoria(material);
      repository.save(material);
  }
   public List<Material> listarTodos() {
  
    return repository.findAll();
    }

    public Material obterPorID(Long id) {

    return repository.findById(id).get();
    }
    public void delete(Long id) {

        Material material = repository.findById(id).get();
         material.setHabilitado(Boolean.FALSE);
         super.preencherCamposAuditoria(material);
  
         repository.save(material);
     }
  
}
