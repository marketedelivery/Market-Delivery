package br.com.marketedelivery.camada.negocio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.dados.ClienteDao;
import br.com.marketedelivery.camada.dados.IClienteDao;
import br.com.marketedelivery.camada.dados.ISupermercadoDao;
import br.com.marketedelivery.camada.dados.SupermercadoDao;

public abstract class DAOFactory
{
	private static final EntityManagerFactory factory;

	public static ISupermercadoDao supermercadoDao;

	public static IClienteDao clienteDao;
	static
	{
		factory = Persistence.createEntityManagerFactory("test");
	}

	public static ISupermercadoDao getSupermercadoDAO()
	{
		supermercadoDao = (ISupermercadoDao) new SupermercadoDao(factory.createEntityManager());
		return supermercadoDao;
	}

	public static IClienteDao getClienteDao()
	{
		clienteDao = (IClienteDao) new ClienteDao(factory.createEntityManager());
		return clienteDao;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}