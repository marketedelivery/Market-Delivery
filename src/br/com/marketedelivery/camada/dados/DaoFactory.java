package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory 
{
    private static final EntityManagerFactory factory;
    
    static{
    	factory = Persistence.createEntityManagerFactory("test");
    }
	public static IClienteDao clienteDao;
	public static IUsuarioDao usuarioDao;
	
	public static IClienteDao getClienteDao()
	{
		clienteDao = new ClienteDao(factory.createEntityManager());
		return clienteDao;
	}
	public static IUsuarioDao getUsuarioDao()
	{
		usuarioDao = new UsuarioDao(factory.createEntityManager());
		return usuarioDao;
	}
}
