package br.unisul.pweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();

	//public List<Estado> findAllByOrderByNome();
	
	List<Estado> findDistinctByNomeContainingOrderByNome(String nome);
}
