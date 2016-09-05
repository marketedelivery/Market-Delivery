package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Cliente;

public class ClienteDao extends DAOGenerico<Cliente>
{
	private EntityManager manager;

	public ClienteDao(EntityManager em)
	{
		super(em);
		this.setManager(em);
	}

	public Cliente buscarClientePorCPF(String cpf_cnpj)
	{
		String consulta = "SELECT c FROM Cliente c WHERE c.cpf_cnpj = :N";
		TypedQuery<Cliente> retorno = getEntityManager().createQuery(consulta, Cliente.class);
		retorno.setParameter("N", cpf_cnpj);
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

	public EntityManager getManager()
	{
		return manager;
	}

	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}