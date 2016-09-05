package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.dados.DaoFactory;
import br.com.marketedelivery.camada.dados.IClienteDao;

@Path("/service")
public class ControladorCliente
{
	private IClienteDao clienteDao;

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo cliente
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarCliente")
	public void cadastrarCliente(Cliente cliente)
	{
		Cliente cli = clienteDao.buscarClientePorCPF(cliente.getCpf());
		if (cli == null)
		{
			clienteDao = new DaoFactory().getClienteDao();
			clienteDao.inserir(cliente);
		} else
		{
			JOptionPane.showMessageDialog(null, "CPF j� cadastrado no sistema", "Aten��o",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Essse método altera uma pessoa já cadastrada
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarCliente")
	public void atualizarCliente(Cliente cliente)
	{
		clienteDao = new DaoFactory().getClienteDao();
		clienteDao.alterar(cliente);
	}

	/**
	 * Esse método lista todos os clientes cadastradas na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listarCliente")
	public List<Cliente> listarCliente()
	{
		clienteDao = new DaoFactory().getClienteDao();
		return clienteDao.consultarTodos();
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/getPessoa/{cpf}")
	 */
	
	/**
	 * Esse método pesquisa o cliente cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarCliente")
	public Cliente pesquisarCliente(String cpf)
	{
		clienteDao = new DaoFactory().getClienteDao();
		Cliente cli = clienteDao.buscarClientePorCPF(cpf);
		if (cli == null)
		{
			JOptionPane.showMessageDialog(null, "Nenhum Cadastro encontrado", "Aten��o",
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		} else
		{
			return cli;
		}
	}
	
	/**
	 * Excluindo uma pessoa pelo código
	 */
	/*@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")*/
}