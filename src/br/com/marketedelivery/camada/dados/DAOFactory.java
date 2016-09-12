/**
 * 
 */
package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;

/**
 * @author Audry Martins
 *
 */
public class DAOFactory
{
	// Atributos
	private static final EntityManagerFactory factory;

	public static IClienteDAO clienteDao;

	public static IProdutoDAO produtoDAO;

	public static IUsuarioDAO usuarioDao;

	public static ISupermercadoDAO supermercadoDAO;
	// Construtores
	static
	{
		factory = Persistence.createEntityManagerFactory("db_marketDelivery");
	}

	public static IClienteDAO getClienteDAO()
	{
		clienteDao = (IClienteDAO) new ClienteDAO(factory.createEntityManager());
		return clienteDao;
	}

	public static IProdutoDAO getProdutoDAO()
	{
		produtoDAO = (IProdutoDAO) new ProdutoDAO(factory.createEntityManager());
		return produtoDAO;
	}

	public static IUsuarioDAO getUsuarioDAO()
	{
		usuarioDao = new UsuarioDAO(factory.createEntityManager());
		return usuarioDao;
	}

	public static ISupermercadoDAO getSupermercadoDAO()
	{
		supermercadoDAO = (ISupermercadoDAO) new SupermercadoDAO(factory.createEntityManager());
		return supermercadoDAO;
	}

	public static void close()
	{
		if (factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}