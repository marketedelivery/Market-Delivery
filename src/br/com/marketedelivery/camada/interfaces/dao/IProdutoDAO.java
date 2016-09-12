/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IProdutoDAO extends IDAOGenerico<Produto>
{
	// Métodos
	public void excluir(Produto produto) throws ProdutoInexistenteException;

	public Produto pesquisarProdutoPorNome(String nome);
}