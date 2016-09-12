package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;

public interface ISupermercadoDAO extends IDAOGenerico<Supermercado>
{
	// Métodos
	public Supermercado pesquisarPorNome(String nome) throws SupermercadoInexistenteException;

	public Supermercado pesquisarPorCNPJ(String cnpj);
}