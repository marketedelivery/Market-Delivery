package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Status;

public class ProdutoDAO extends DAOGenerico<Produto>
{
	// Atributos
	private EntityManager manager;

	// Construtores
	public ProdutoDAO(EntityManager em)
	{
		super(em);
		this.setManager(em);
	}

	// Métodos
	/**
	 * Executa a exclusão lógica do objeto que se encontra em mem�ria.
	 * 
	 * @param objeto
	 *            a ser realizado a exclusão lógica
	 * @return objeto que foi executado a exclusão lógica
	 */
	public void excluir(Produto produto)
	{
		EntityTransaction tx = getEntityManager().getTransaction();
		try
		{
			tx.begin();
			produto = getEntityManager().merge(produto);
			produto.setStatus(Status.INATIVO);
			tx.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			if (tx != null && tx.isActive())
			{
				tx.rollback();
			}
		}
	}

	public Produto pesquisarProdutoPorNome(String nome)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.nome = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", nome);
		Produto resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public Produto pesquisarProdutoPorPreco(double preco)
	{
		String consulta = "SELECT p FROM Produto p WHERE p.preco = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", preco);
		Produto resultado;
		try
		{
			resultado = retorno.getSingleResult();
			return resultado;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	// Gets e Sets
	public EntityManager getManager()
	{
		return manager;
	}

	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}