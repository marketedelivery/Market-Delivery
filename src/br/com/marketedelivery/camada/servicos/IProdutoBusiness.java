package br.com.marketdelivery.service;

import java.util.List;

import br.com.marketdelivery.domain.Produto;
import br.com.marketdelivery.util.BusinessException;

public interface IProdutoBusiness {
	public void criaProduto(Produto produto) throws BusinessException;

	public void atualizaProduto(Produto produto) throws BusinessException;

	public void deletaProduto(Produto produto);

	public Produto buscaProduto(Integer codigo);

	public List<Produto> listaProdutos();
}