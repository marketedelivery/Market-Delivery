package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;

public interface IControladorProduto
{
	// Métodos
	public void cadastrarProduto(Produto produto) throws ProdutoExistenteException;

	public void alterarProduto(Produto produto) throws ProdutoInexistenteException;

	public List<Produto> consultarTodosProdutos() throws ProdutoInexistenteException;

	public Produto pesquisarProduto(String nome) throws ProdutoInexistenteException;

	public Produto pesquisarProdutoPorId(int codigo) throws ProdutoInexistenteException;
}