/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
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

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.ISupermercadoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorSupermercado;

@Path("/service")
public class ControladorSupermercado implements IControladorSupermercado
{
	private ISupermercadoDAO supermercadoDAO;

	/**
	 * @throws SupermercadoInexistenteException
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo supermercado
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarSupermercado")
	public void cadastrarSupermercado(Supermercado supermercado) throws SupermercadoExistenteException
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado cli = supermercadoDAO.pesquisarPorCNPJ(supermercado.getCnpj());
		if (cli == null)
		{
			supermercadoDAO.inserir(supermercado);
		} else
		{
			throw new SupermercadoExistenteException();
		}
	}

	/**
	 * Essse método altera um supermercado já cadastrado
	 * 
	 * @throws SupermercadoInexistenteException
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSupermercado")
	public void alterarSupermercado(Supermercado supermercado) throws SupermercadoInexistenteException
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarPorCNPJ(supermercado.getCnpj());
		if (s != null)
		{
			supermercadoDAO.alterar(supermercado);
		} else
		{
			throw new SupermercadoInexistenteException();
		}
	}

	/**
	 * Excluindo um supermercado pelo código
	 * 
	 * @throws SupermercadoInexistenteException
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir")
	public void excluirSupermercado(Supermercado supermercado) throws SupermercadoInexistenteException
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado cli = supermercadoDAO.pesquisarPorCNPJ(supermercado.getCnpj());
		if (cli != null)
		{
			// supermercadoDao.excluir(supermercado);
		} else
		{
			throw new SupermercadoInexistenteException();
		}
	}

	/**
	 * Esse método busca um supermercado cadastrad pelo CNPJ
	 * 
	 * @throws SupermercadoInexistenteException
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercado/{cnpj}")
	public Supermercado pesquisarSupermercado(@PathParam("cnpj") String Cnpj) throws SupermercadoInexistenteException
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.pesquisarPorCNPJ(Cnpj);
		if (s != null)
		{
			return s;
		} else
		{
			throw new SupermercadoInexistenteException();
		}
	}

	/**
	 * Esse método busca um supermercado cadastrado pelo código
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorCodigo/{codigo}")
	public Supermercado pesquisarSupermercadoPorCodigo(@PathParam("codigo") int codigo)
			throws SupermercadoInexistenteException
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.consultarPorId(codigo);
		if (s != null)
		{
			return s;
		} else
		{
			throw new SupermercadoInexistenteException();
		}
	}

	/**
	 * Esse método lista todos os supermercados cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasPessoas")
	public List<Supermercado> listarTodosSupermercados() throws SupermercadoInexistenteException
	{
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		List<Supermercado> supermercados = supermercadoDAO.consultarTodos();
		if (supermercados == null || supermercados.size() == 0)
		{
			throw new SupermercadoInexistenteException();
		} else
		{
			return supermercados;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorSupermercado
	 * #pesquisarSupermercadoPorCnpj(java.lang.String)
	 */
	@Override
	public Supermercado pesquisarSupermercadoPorCnpj(String cnpj) throws SupermercadoInexistenteException
	{
		return supermercadoDAO.pesquisarPorCNPJ(cnpj);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorSupermercado
	 * #consultarTodosSupermercados()
	 */
	@Override
	public List<Supermercado> consultarTodosSupermercados() throws SupermercadoInexistenteException
	{
		return supermercadoDAO.consultarTodos();
	}
}