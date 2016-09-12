/**
 * 
 */
package br.com.marketedelivery.camada.interfaces.negocio;


import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInxistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorUsuario
{
	// Métodos
	public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException;

	public void alterarUsuario(Usuario usuario) throws UsuarioInxistenteException;

	public void excluirUsuario(Usuario usuario) throws UsuarioInxistenteException;

	public List<Usuario> consultarTodosUsuarios() throws UsuarioInxistenteException;
}