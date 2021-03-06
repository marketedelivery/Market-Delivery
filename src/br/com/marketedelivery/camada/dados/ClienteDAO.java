package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;

public class ClienteDAO extends DAOGenerico<Cliente> implements IClienteDAO
{
	private EntityManager manager;

	public ClienteDAO(EntityManager em)
	{
		super(em);
		this.setManager(em);
	}

	public Cliente pesquisarClientePorCPF(String cpf)
	{
		String consulta = "SELECT c FROM Cliente c WHERE c.cpf = :N";
		TypedQuery<Cliente> retorno = getEntityManager().createQuery(consulta, Cliente.class);
		retorno.setParameter("N", cpf);
		Cliente resultado;
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

	public void excluirCliente(Cliente cliente)
	{
		EntityTransaction tx = getEntityManager().getTransaction();
		try
		{
			tx.begin();
			cliente = getEntityManager().merge(cliente);
			cliente.getUsuario().setStatus(Status.INATIVO);
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

	public EntityManager getManager()
	{
		return manager;
	}

	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}