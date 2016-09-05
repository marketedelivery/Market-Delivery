package br.com.marketedelivery.camada.servicos;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.util.BusinessException;

public interface IProdutoBusiness
{
	public void criaProduto(Produto produto) throws BusinessException;

	public void atualizaProduto(Produto produto) throws BusinessException;

	public void deletaProduto(Produto produto);

	public Produto buscaProduto(Integer codigo);

	public List<Produto> listaProdutos();
}