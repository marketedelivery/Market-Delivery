/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorCliente
{
	//Métodos
	public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException;

	public void alterarCliente(Cliente cliente) throws ClienteInexistenteException;

	public void excluirCliente(Cliente cliente) throws ClienteInexistenteException;

	public List<Cliente> consultarTodosClientes() throws ClienteInexistenteException;

	public Cliente pesquisarCliente(String cpf) throws ClienteInexistenteException;
}