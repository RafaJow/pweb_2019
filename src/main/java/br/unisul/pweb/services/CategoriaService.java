package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository rep;

	//BUSCAR POR NOME
	public List<Categoria> buscaPorNome(String nome){
		return rep.findDistinctByNomeContainingOrderByNome(nome);
	}
	
	//BUSCAR POR ID
	public Categoria find (Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElse(null);
	}

	//INSERIR
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}

	//LISTAR TODAS
	public List<Categoria> findAll(){
		return rep.findAll();
	}
	
	
}
