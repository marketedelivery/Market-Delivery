/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import br.com.marketedelivery.camada.dados.ISupermercadoDao;

@Path("/service")
public class ControladorSupermercado
{
	private ISupermercadoDao supermercadoDao;

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo supermercado
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarSupermercado")
	public void cadastrarSupermercado(Supermercado supermercado)
	{
		supermercadoDao = DAOFactory.getSupermercadoDAO();
		Supermercado cli = supermercadoDao.buscarPorCNPJ(supermercado.getCnpj());
		if (cli == null)
		{
			supermercadoDao.inserir(supermercado);
		} else
		{
		}
	}

	
	/**
	 * Essse método altera um supermercado já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSupermercado")
	public void alterarSupermercado(Supermercado supermercado)
	{
		supermercadoDao = DAOFactory.getSupermercadoDAO();
		Supermercado cli = supermercadoDao.buscarPorCNPJ(supermercado.getCnpj());
		if (cli != null)
		{
			supermercadoDao.alterar(supermercado);
		} else
		{
		}
	}

	
	/**
	 * Excluindo um supermercado pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir")
	public void excluirSupermercado(Supermercado supermercado)
	{
		supermercadoDao = DAOFactory.getSupermercadoDAO();
		Supermercado cli = supermercadoDao.buscarPorCNPJ(supermercado.getCnpj());
		if (cli != null)
		{
			supermercadoDao.remover(supermercado);
		} else
		{
		}
	}

	/**
	 * Esse método busca um supermercado cadastrad pelo CNPJ
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercado/{cnpj}")
	public Supermercado pesquisarSupermercado(@PathParam("cnpj") String Cnpj)
	{
		supermercadoDao = DAOFactory.getSupermercadoDAO();
		Supermercado c = supermercadoDao.buscarPorCNPJ(Cnpj);
		if (c != null)
		{
			return c;
		} else
		{
			return null;
		}
	}

	/**
	 * Esse método busca um supermercado cadastrado pelo código
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorCodigo/{codigo}")
	public Supermercado pesquisarSupermercadoPorCodigo(@PathParam("codigo") int codigo)
	{
		supermercadoDao = DAOFactory.getSupermercadoDAO();
		Supermercado cp = supermercadoDao.consultarPorId(codigo);
		if (cp != null)
		{
			return cp;
		} else
		{
			return null;
		}
	}
	
	/**
	 * Esse método lista todos os supermercados cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasPessoas")
	public List<Supermercado> listarTodosSupermercados()
	{
		supermercadoDao = DAOFactory.getSupermercadoDAO();
		return supermercadoDao.consultarTodos();
	}
}