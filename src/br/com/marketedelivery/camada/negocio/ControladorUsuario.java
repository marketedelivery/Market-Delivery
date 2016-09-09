package br.com.marketedelivery.camada.negocio;

import javax.swing.JOptionPane;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.dados.DaoFactory;
import br.com.marketedelivery.camada.dados.IUsuarioDao;
import br.com.marketedelivery.camada.dados.UsuarioDao;


public class ControladorUsuario {

	IUsuarioDao usuarioDao;
	
	public Usuario validaUsuario(Usuario us){
		try {
			if(us != null){
			usuarioDao =  DaoFactory.getUsuarioDao();
			Usuario usuario = usuarioDao.validarUsuario(us);
			
			if(us.getSenha().equals(usuario.getSenha())){
				
				return usuario;
			}
		}else{	
					JOptionPane.showMessageDialog(null, "usuario ou senha incorreto", "Aten��o",
					JOptionPane.INFORMATION_MESSAGE);
				 }
		} catch (Exception e) {
			return null;
		}
			return null;
		}
	
}
