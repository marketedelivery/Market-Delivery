package br.com.marketdelivery.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;

import br.com.marketdelivery.domain.Produto;
import br.com.marketdelivery.facade.ProdutoFacade;
import br.com.marketdelivery.util.BusinessException;
import br.com.marketdelivery.util.Constants;

@Path("/produtos")

public class ProdutoResource implements IProdutoResource{
	
	//TODO @Inject
	private ProdutoFacade produtoFacade;
	private Produto produto;
	
	
	@Override
	public Response criarProdutos(@QueryParam("nome") String nome, @QueryParam("descricao") String descricao ){
		
		produto.setNome(nome);
		produto.setDescricao(descricao);
		
		try{
			produtoFacade.criaProduto(produto);
			return Response.ok().entity(Constants.SUCESS).build();
		}catch(BusinessException e){
			return Response.status(Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
		}
		
		
		
		
	}

	@Override
	public Response listarProdutos(Integer codigo) {
		// TODO Auto-generated method stub
		try{
			produtoFacade.listaProdutos();
			return Response.ok().entity(Constants.SUCESS).build();
		}catch(Exception e){
			return Response.status(Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response buscarProduto(Integer codigoProduto) {
		try{
			produtoFacade.buscaProduto(codigoProduto);
			return Response.ok().entity(Constants.SUCESS).build();
		}catch(Exception e){
			return Response.status(Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
		}
		
	}

	@Override
	public Response atualizarProduto(Integer codigo, Produto produto) {
		produto.setCodigo(codigo);
		
		try{
			produtoFacade.atualizaProduto(produto);
			return Response.ok().entity(Constants.SUCESS).build();
		}catch(BusinessException e){
			return Response.status(Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
		}
	}
	

}
