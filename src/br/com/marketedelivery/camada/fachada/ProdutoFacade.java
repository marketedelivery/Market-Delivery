package br.com.marketdelivery.facade;

import java.util.List;

import br.com.marketdelivery.domain.Produto;
import br.com.marketdelivery.service.IProdutoBusiness;
import br.com.marketdelivery.util.BusinessException;

public class ProdutoFacade {

	private IProdutoBusiness produtoBusiness;

	public void criaProduto(Produto produto) throws BusinessException {
		produtoBusiness.criaProduto(produto);
	}

	public void atualizaProduto(Produto produto) throws BusinessException {
		produtoBusiness.atualizaProduto(produto);
	}

	public Produto buscaProduto(Integer codigo) {
		return produtoBusiness.buscaProduto(codigo);
	}

	public List<Produto> listaProdutos() {
		return produtoBusiness.listaProdutos();
	}
}