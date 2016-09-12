package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.exceptions.UsuarioInxistenteException;

public interface IUsuarioDAO extends IDAOGenerico<Usuario>
{
	// Métodos
	public Usuario validarUsuario(Usuario usuario) throws UsuarioInxistenteException;
}