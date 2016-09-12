package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Usuario;

public interface IUsuarioDAO extends IDAOGenerico<Usuario>
{
	// Métodos
	public Usuario validarUsuario(Usuario usuario);

	public Usuario pesquisarUsuarioPorEmail(String email);
}