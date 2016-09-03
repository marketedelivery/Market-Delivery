package br.com.marketedelivery.camada.dados;



import br.com.marketdelivery.domain.Produto;

public class ProdutoDao extends GenericDaoImpl<Produto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void delete(Produto produto) {
    	super.delete(produto.getCodigo(), Produto.class);
}

}
