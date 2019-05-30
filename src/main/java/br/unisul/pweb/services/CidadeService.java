package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Cidade;
import br.unisul.pweb.domain.Estado;
import br.unisul.pweb.repository.CidadeRepository;
import br.unisul.pweb.repository.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository rep;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	//BUSCAR POR ID
	public Cidade find(Integer id) {
		Optional<Cidade> obj = rep.findById(id);
		return obj.orElse(null);
	}

	
	public List<Cidade> search(String nome, List<Integer> ids){
		List<Estado> estado = estadoRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndEstadoIn(nome, estado);
	}
	
	
	public List<Cidade> findByEstado(Integer estadoId) {
		return rep.findCidades(estadoId);
	}
	
	
	//INSERIR
	public Cidade insert (Cidade obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Cidade update (Cidade obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
		
	//LISTAR TODAS
	public List<Cidade> findAll(){
		return rep.findAll();
	}
	
}
