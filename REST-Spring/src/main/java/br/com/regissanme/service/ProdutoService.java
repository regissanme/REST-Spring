package br.com.regissanme.service;

import java.util.List;

import br.com.regissanme.entity.Produto;
import br.com.regissanme.exceptions.ProductNullException;
import br.com.regissanme.exceptions.ProductPriceException;
import br.com.regissanme.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto save(Produto produto) throws Exception {
		if (produto.getNome() == null || produto.getPreco() == null)
			throw new ProductNullException();
		if (produto.getPreco() < 0)
			throw new ProductPriceException();
		return repository.save(produto);
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}
}
