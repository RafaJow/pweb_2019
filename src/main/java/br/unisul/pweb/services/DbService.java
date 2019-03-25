package br.unisul.pweb.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Estado;
import br.unisul.pweb.repository.CategoriaRepository;
import br.unisul.pweb.repository.EstadoRepository;

@Service
public class DbService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public void inicializaBancoDeDados() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Estado est1 = new Estado(null, "RS");
		Estado est2 = new Estado(null, "SC");
		Estado est3 = new Estado(null, "PR");
		Estado est4 = new Estado(null, "MT");
		Estado est5 = new Estado(null, "SP");
		Estado est6 = new Estado(null, "RJ");
		Estado est7 = new Estado(null, "ES");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7));
	}

}
