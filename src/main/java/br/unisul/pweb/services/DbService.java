package br.unisul.pweb.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Cidade;
import br.unisul.pweb.domain.Cliente;
import br.unisul.pweb.domain.Endereco;
import br.unisul.pweb.domain.Estado;
import br.unisul.pweb.domain.Produto;
import br.unisul.pweb.domain.enums.TipoCliente;
import br.unisul.pweb.repository.CategoriaRepository;
import br.unisul.pweb.repository.CidadeRepository;
import br.unisul.pweb.repository.ClienteRepository;
import br.unisul.pweb.repository.EnderecoRepository;
import br.unisul.pweb.repository.EstadoRepository;
import br.unisul.pweb.repository.ProdutoRepository;

@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Cidade c1 = new Cidade(null, "Curitiba", est3);
		Cidade c2 = new Cidade(null, "Tubarão", est2);
		Cidade c3 = new Cidade(null, "Gravatal", est2);
		Cidade c4 = new Cidade(null, "Laguna", est2);
		Cidade c5 = new Cidade(null, "Porto Alegre", est1);
		Cidade c6 = new Cidade(null, "Guaíba", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		est3.getCidades().addAll(Arrays.asList(c5, c6));
		
		Cliente cli1 = new Cliente(null, "Joao Silva", "joao@gmail.com", "12312312312", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("48111231212", "48133232323"));

		Endereco en1 = new Endereco(null, "avenida 5 ", "123", "Apto 14", "centro"     , "1212121", cli1, c2);
		Endereco en2 = new Endereco(null, "avenida 12", "123", "Casa"    , "lagoa", "123123", cli1, c3);
		cli1.getEnderecos().addAll(Arrays.asList(en1, en2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));

		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(en1, en2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
