package br.com.marketedelivery.camada.fachada;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.servicos.IProdutoBusiness;
import br.com.marketedelivery.camada.util.BusinessException;

public class ProdutoFacade
{
	private IProdutoBusiness produtoBusiness;

	public void criaProduto(Produto produto) throws BusinessException
	{
		produtoBusiness.criaProduto(produto);
	}

	public void atualizaProduto(Produto produto) throws BusinessException
	{
		produtoBusiness.atualizaProduto(produto);
	}

	public Produto buscaProduto(Integer codigo)
	{
		return produtoBusiness.buscaProduto(codigo);
	}

	public List<Produto> listaProdutos()
	{
		return produtoBusiness.listaProdutos();
	}
}