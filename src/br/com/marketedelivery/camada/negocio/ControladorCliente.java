package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IClienteDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorCliente;

@Path("/service")
public class ControladorCliente implements IControladorCliente
{
	private IClienteDAO clienteDAO;

	/**
	 * @throws ClienteInexistenteException
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo cliente
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarCliente")
	public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException
	{
		Cliente c = clienteDAO.buscarClientePorCPF(cliente.getCpf());
		if (c == null)
		{
			new DAOFactory();
			clienteDAO = DAOFactory.getClienteDAO();
			clienteDAO.inserir(cliente);
		} else
		{
			throw new ClienteExistenteException();
		}
	}

	/**
	 * Essse método altera um cliente já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarCliente")
	public void alterarCliente(Cliente cliente) throws ClienteInexistenteException
	{
		Cliente c = clienteDAO.buscarClientePorCPF(cliente.getCpf());
		if (c != null)
		{
			new DAOFactory();
			clienteDAO = DAOFactory.getClienteDAO();
			clienteDAO.alterar(cliente);
		} else
		{
			throw new ClienteInexistenteException();
		}
	}

	/**
	 * Esse método lista todos os clientes cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodosClientes")
	public List<Cliente> consultarTodosClientes() throws ClienteInexistenteException
	{
		List<Cliente> clientes = clienteDAO.consultarTodos();
		if (clientes == null || clientes.size() == 0)
		{
			throw new ClienteInexistenteException();
		} else
		{
			new DAOFactory();
			clienteDAO = DAOFactory.getClienteDAO();
			return clientes;
		}
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/pesquisarCliente/{cpf}")
	 */
	/**
	 * Esse método pesquisa o cliente cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarCliente/{cpf}")
	public Cliente pesquisarCliente(@PathParam("cpf") String cpf) throws ClienteInexistenteException
	{
		new DAOFactory();
		clienteDAO = DAOFactory.getClienteDAO();
		Cliente cliente = clienteDAO.buscarClientePorCPF(cpf);
		if (cliente == null)
		{
			throw new ClienteInexistenteException();
		} else
		{
			return cliente;
		}
	}

	/**
	 * Excluindo um cliente pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirCliente/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.negocio.IControladorCliente#excluirCliente(
	 * br.com.marketedelivery.camada.classesBasicas.Cliente)
	 */
	@Override
	public void excluirCliente(@PathParam("codigo") Cliente cliente) throws ClienteInexistenteException
	{
		new DAOFactory();
		clienteDAO = DAOFactory.getClienteDAO();
		Cliente c = clienteDAO.buscarClientePorCPF(cliente.getCpf());
		if (c == null)
		{
			cliente.getUsuario().setStatus(Status.INATIVO);
			clienteDAO.alterar(cliente);
		} else
		{
			throw new ClienteInexistenteException();
		}
	}
}