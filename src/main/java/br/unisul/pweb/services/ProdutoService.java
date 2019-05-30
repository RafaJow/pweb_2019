package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Produto;
import br.unisul.pweb.repository.CategoriaRepository;
import br.unisul.pweb.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public List<Produto> search(String nome, List<Integer> ids) {
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias);
	}
	
	//BUSCAR POR NOME
	public List<Produto> buscaPorNome(String nome){
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, null);
	}
	
	//BUSCAR POR ID
	public Produto find (Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Produto insert (Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	//ATUALIZAR
	public Produto update (Produto obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Produto> findAll(){
		return repo.findAll();
	}
}
