package br.com.marketedelivery.camada.servicos;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.dados.ProdutoDao;
import br.com.marketedelivery.camada.util.BusinessException;
import br.com.marketedelivery.camada.util.Constants;

public class ProdutoBusiness implements IProdutoBusiness
{
	private ProdutoDao produtoDao;

	public void validaProduto(Produto produto) throws BusinessException
	{
		if (produto.getNome() == null || produto.getDescricao() == null)
		{
			throw new BusinessException(Constants.MANDATORY_VALIDATION);
		}
	}

	public ProdutoBusiness(ProdutoDao produtoDao)
	{
		this.produtoDao = produtoDao;
	}

	public void criaProduto(Produto produto) throws BusinessException
	{
		validaProduto(produto);
		produtoDao.inicializaTransaction();
		produtoDao.salva(produto);
		produtoDao.commitEfinalizaTransaction();
	}

	public void atualizaProduto(Produto produto) throws BusinessException
	{
		validaProduto(produto);
		produtoDao.inicializaTransaction();
		Produto produtoRetornado = produtoDao.busca(produto.getCodigo());
		mapProduto(produtoRetornado, produto);
		produtoDao.commitEfinalizaTransaction();
	}

	public void deletaProduto(Produto produto)
	{
		produtoDao.inicializaTransaction();
		Produto produtoRetornado = produtoDao.busca(produto.getCodigo());
		produtoDao.delete(produtoRetornado);
		produtoDao.commitEfinalizaTransaction();
	}

	public Produto buscaProduto(Integer codigo)
	{
		produtoDao.inicializaTransaction();
		;
		Produto produto = produtoDao.busca(codigo);
		produtoDao.finalizaTransaction();
		;
		return produto;
	}

	public List<Produto> listaProdutos()
	{
		produtoDao.inicializaTransaction();
		List<Produto> result = produtoDao.lista();
		produtoDao.finalizaTransaction();
		return result;
	}

	public void mapProduto(Produto produtoRetornado, Produto produtoAtualizado)
	{
		if (produtoRetornado != null && produtoAtualizado != null)
		{
			produtoRetornado.setNome(produtoAtualizado.getNome());
			produtoRetornado.setDescricao(produtoAtualizado.getDescricao());
		}
	}
}