package br.com.marketedelivery.camada.interfaces.negocio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.marketedelivery.camada.classesBasicas.Produto;

public interface IProdutoResource {

	@GET
	@Produces("application/json")
	Response listarProdutos(@QueryParam("filtroCodigoProduto") Integer codigo);

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	Response criarProdutos(@QueryParam("nome") String nome, @QueryParam("descricao") String descricao);

	@GET
	@Produces("application/json")
	@Path("/{codigo}")
	Response buscarProduto(@PathParam("codigoProduto") Integer codigoProduto);

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{codigo}")
	Response atualizarProduto(@PathParam("codigoProduto") Integer codigo, @QueryParam("produto") Produto produto);
}