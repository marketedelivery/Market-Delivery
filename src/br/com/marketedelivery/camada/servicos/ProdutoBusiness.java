package br.com.marketdelivery.service;

import java.util.List;

import br.com.marketdelivery.dao.ProdutoDao;
import br.com.marketdelivery.domain.Produto;
import br.com.marketdelivery.util.BusinessException;
import br.com.marketdelivery.util.Constants;

public class ProdutoBusiness implements IProdutoBusiness {

	private ProdutoDao produtoDao;

	public void validaProduto(Produto produto) throws BusinessException {

		if (produto.getNome() == null || produto.getDescricao() == null) {

			throw new BusinessException(Constants.MANDATORY_VALIDATION);
		}

	}

	public ProdutoBusiness(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	public void criaProduto(Produto produto) throws BusinessException {
		validaProduto(produto);
		produtoDao.inicializaTransaction();
		produtoDao.salva(produto);
		produtoDao.commitEfinalizaTransaction();
	}

	public void atualizaProduto(Produto produto) throws BusinessException {
		validaProduto(produto);
		produtoDao.inicializaTransaction();
		Produto produtoRetornado = produtoDao.busca(produto.getCodigo());
		mapProduto(produtoRetornado, produto);
		produtoDao.commitEfinalizaTransaction();
	}

	public void deletaProduto(Produto produto) {
		produtoDao.inicializaTransaction();
		Produto produtoRetornado = produtoDao.busca(produto.getCodigo());
		produtoDao.delete(produtoRetornado);
		produtoDao.commitEfinalizaTransaction();

	}

	public Produto buscaProduto(Integer codigo) {
		produtoDao.inicializaTransaction();
		;
		Produto produto = produtoDao.busca(codigo);
		produtoDao.finalizaTransaction();
		;
		return produto;
	}

	public List<Produto> listaProdutos() {
		produtoDao.inicializaTransaction();
		List<Produto> result = produtoDao.lista();
		produtoDao.finalizaTransaction();

		return result;
	}

	public void mapProduto(Produto produtoRetornado, Produto produtoAtualizado) {
		if (produtoRetornado != null && produtoAtualizado != null) {
			produtoRetornado.setNome(produtoAtualizado.getNome());
			produtoRetornado.setDescricao(produtoAtualizado.getDescricao());
		}
	}

}
