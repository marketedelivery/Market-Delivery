package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInxistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorUsuario;

@Path("/service")
public class ControladorUsuario implements IControladorUsuario
{
	IUsuarioDAO usuarioDAO;

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 *           Esse método cadastra um novo Usuário
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUsuario")
	public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException
	{
		usuarioDAO.inserir(usuario);
	}

	/**
	 * Essse método altera um Usuário já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUsuario") // Falta o método Atualizar Usuário
	public void alterarUsuario(Usuario usuario) throws UsuarioInxistenteException
	{
		usuarioDAO.alterar(usuario);
	}

	/**
	 * Esse método lista todos os Usuários cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodosUsuarios") // Falta o método consultar todos os
										// Usuários
	public List<Usuario> consultarTodosUsuarios() throws UsuarioInxistenteException
	{
		return usuarioDAO.consultarTodos();
	}

	/**
	 * Excluindo um Usuário pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirUsuario/{codigo}")
	public void excluirUsuario(Usuario usuario) throws UsuarioInxistenteException
	{
		// usuarioDAO.excluir(usuario);
	}

	public Usuario validaUsuario(Usuario us) throws UsuarioInxistenteException
	{
		try
		{
			if (us != null)
			{
				usuarioDAO = DAOFactory.getUsuarioDAO();
				Usuario usuario = usuarioDAO.validarUsuario(us);
				if (us.getSenha().equals(usuario.getSenha()))
				{
					return usuario;
				}
			} else
			{
				throw new UsuarioInxistenteException();
			}
		}
		catch (Exception e)
		{
			return null;
		}
		return null;
	}
}