/**
 * 
 */
package br.com.marketedelivery.camada.negocio.regras;

import javax.persistence.EntityManager;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.dados.ClienteDAO;
import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;

/**
 * @author Audry Martins
 *
 */
public class RNCliente
{
	// Atributos
	EntityManager em;

	private IClienteDAO clienteDAO = new ClienteDAO(em);

	// Métodos
	public boolean verificarClienteExistente(Cliente cliente)
	{
		// new DAOFactory();
		// clienteDAO = DAOFactory.getClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.pesquisarClientePorCPF(cliente.getCpf());
		if (c == null)
		{
			return false;
		} else
		{
			return true;
		}
	}
}
