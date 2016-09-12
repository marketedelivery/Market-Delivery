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

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IProdutoDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto;

@Path("/service")
public class ControladorProduto implements IControladorProduto
{
	private IProdutoDAO produtoDAO;

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo Produto
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public void cadastrarProduto(Produto produto) throws ProdutoExistenteException
	{
		Produto p = produtoDAO.pesquisarProdutoPorNome(produto.getNome());
		if (p == null)
		{
			new DAOFactory();
			produtoDAO = DAOFactory.getProdutoDAO();
			produtoDAO.inserir(produto);
		} else
		{
			throw new ProdutoExistenteException();
		}
	}

	/**
	 * Essse método altera um cliente já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarProduto")
	public void alterarProduto(Produto produto) throws ProdutoInexistenteException
	{
		Produto p = produtoDAO.pesquisarProdutoPorNome(produto.getNome());
		if (p != null)
		{
			new DAOFactory();
			produtoDAO = DAOFactory.getProdutoDAO();
			produtoDAO.alterar(produto);
		} else
		{
			throw new ProdutoInexistenteException();
		}
	}

	/**
	 * Excluindo um produto pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirProduto/{codigo}")
	public void excluirProduto(@PathParam("codigo") Produto produto) throws ProdutoInexistenteException
	{
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto produtoRetornado = produtoDAO.consultarPorId(produto.getCodigo());
		if (produtoRetornado == null)
		{
			throw new ProdutoInexistenteException();
		} else
		{
			produtoDAO.excluir(produtoRetornado);
		}
	}

	/**
	 * Esse método lista todos os clientes cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodosProdutos")
	public List<Produto> consultarTodosProdutos() throws ProdutoInexistenteException
	{
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> produtos = produtoDAO.consultarTodos();
		if (produtos != null && produtos.size() > 0)
		{
			return produtos;
		} else
		{
			throw new ProdutoInexistenteException();
		}
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/getPessoa/{cpf}")
	 */
	/**
	 * Esse método pesquisa o produto cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarProduto/{nome}")
	public Produto pesquisarProduto(@PathParam("nome") String nome) throws ProdutoInexistenteException
	{
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.pesquisarProdutoPorNome(nome);
		if (p == null)
		{
			throw new ProdutoInexistenteException();
		} else
		{
			return p;
		}
	}

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Path("/pesquisarProdutoPorId/{codigo}")
	 */
	/**
	 * Esse método pesquisa o produto cadastrado na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorId/{codigo}")
	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto#
	 * pesquisarProdutoPorId(int)
	 */
	@Override
	public Produto pesquisarProdutoPorId(@PathParam("codigo") int codigo) throws ProdutoInexistenteException
	{
		new DAOFactory();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.consultarPorId(codigo);
		if (p == null)
		{
			throw new ProdutoInexistenteException();
		} else
		{
			return p;
		}
	}
}