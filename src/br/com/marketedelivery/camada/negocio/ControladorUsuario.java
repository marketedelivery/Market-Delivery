package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.dados.DAOFactory;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
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
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(usuario.getEmail());
		if (u == null)
		{
			usuarioDAO.inserir(usuario);
		} else
		{
			throw new UsuarioExistenteException();
		}
	}

	/**
	 * Essse método altera um Usuário já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUsuario")
	public void alterarUsuario(Usuario usuario) throws UsuarioInexistenteException
	{
		Usuario u = usuarioDAO.pesquisarUsuarioPorEmail(usuario.getEmail());
		if (u != null)
		{
			usuarioDAO.alterar(usuario);
		} else
		{
			throw new UsuarioInexistenteException();
		}
	}

	/**
	 * Esse método lista todos os Usuários cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodosUsuarios")
	public List<Usuario> consultarTodosUsuarios() throws UsuarioInexistenteException
	{
		List<Usuario> usuarios = usuarioDAO.consultarTodos();
		if (usuarios == null || usuarios.size() == 0)
		{
			throw new UsuarioInexistenteException();
		} else
		{
			return usuarios;
		}
	}

	/**
	 * Excluindo um Usuário pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirUsuario/{codigo}")
	public void excluirUsuario(@PathParam("codigo") Usuario usuario) throws UsuarioInexistenteException
	{
		new DAOFactory();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario u = usuarioDAO.consultarPorId(usuario.getCodigo());
		if (u == null)
		{
			throw new UsuarioInexistenteException();
		} else
		{
			usuario.setStatus(Status.INATIVO);
			usuarioDAO.alterar(usuario);
		}
	}
}