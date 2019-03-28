package br.unisul.pweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	List<Produto> findDistinctByNomeContainingAndCategoriasIn(
			String nome,
			List<Categoria> categorias
	); 

}
