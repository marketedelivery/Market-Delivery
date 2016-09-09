package br.com.marketedelivery.camada.dados;

import br.com.marketedelivery.camada.classesBasicas.Usuario;

public interface IUsuarioDao {
	
	public Usuario validarUsuario(Usuario us);
	
	public void inserirUsuario(Usuario us);
	
}
