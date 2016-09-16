package br.com.marketedelivery.camada.negocio;

import java.util.ArrayList;
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
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;
import br.com.marketedelivery.camada.interfaces.dao.IUsuarioDAO;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorUsuario;
import br.com.marketedelivery.camada.negocio.regras.RNUsuario;
import br.com.marketedelivery.camada.util.Mensagens;

@Path("/service")
public class ControladorUsuario implements IControladorUsuario
{
	private IUsuarioDAO usuarioDAO;

	RNUsuario rnUsuario = new RNUsuario();

	private Mensagens msg = new Mensagens();

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
	public String cadastrarUsuario(Usuario usuario)
	{
		boolean existe = false;
		try
		{
			try
			{
				existe = rnUsuario.verificarUsuarioExistente(usuario);
			}
			catch (UsuarioInexistenteException e)
			{
				e.printStackTrace();
				e.getMessage();
			}
			if (existe == false)
			{
				usuarioDAO.inserir(usuario);
			}
			return msg.getMsg_usuario_cadastrado_com_sucesso();
		}
		catch (ClienteExistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoExistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoExistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioExistenteException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
	}

	/**
	 * Essse método altera um Usuário já cadastrado
	 **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarUsuario")
	public String alterarUsuario(Usuario usuario)
	{
		new DAOFactory();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		try
		{
			// Validar o usuario.
			usuarioDAO.alterar(usuario);
			return msg.getMsg_usuario_alterado_com_sucesso();
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
	}

	/**
	 * Esse método lista todos os Usuários cadastrados na base
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/consultarTodosUsuarios")
	public List<Usuario> consultarTodosUsuarios()
	{
		new DAOFactory();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		List<Usuario> usuarios = new ArrayList<>();
		try
		{
			usuarios = usuarioDAO.consultarTodos();
			return usuarios;
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}

	/**
	 * Excluindo um Usuário pelo código
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/excluirUsuario/{codigo}")
	public String excluirUsuario(@PathParam("codigo") int codigo)
	{
		new DAOFactory();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		try
		{
			// Validar o usuario.
			Usuario user = usuarioDAO.consultarPorId(codigo);
			user.setStatus(Status.INATIVO);
			usuarioDAO.alterar(user);
			return msg.getMsg_usuario_excluido_com_sucesso();
		}
		catch (ClienteInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (ProdutoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (SupermercadoInexistenteException e)
		{
			// e.printStackTrace();
		}
		catch (UsuarioInexistenteException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
	}
}