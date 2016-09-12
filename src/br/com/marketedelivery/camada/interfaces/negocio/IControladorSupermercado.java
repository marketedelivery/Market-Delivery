/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorSupermercado
{
	// Métodos
	public void cadastrarSupermercado(Supermercado Supermercado) throws SupermercadoExistenteException;

	public void alterarSupermercado(Supermercado Supermercado) throws SupermercadoInexistenteException;

	public void excluirSupermercado(Supermercado Supermercado) throws SupermercadoInexistenteException;

	public Supermercado pesquisarSupermercadoPorCnpj(String cnpj) throws SupermercadoInexistenteException;

	public Supermercado pesquisarSupermercadoPorId(int codigo) throws SupermercadoInexistenteException;

	public List<Supermercado> consultarTodosSupermercados() throws SupermercadoInexistenteException;
}