package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.classesBasicas.Cliente;
import br.com.marketedelivery.camada.classesBasicas.Produto;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.exceptions.ClienteExistenteException;
import br.com.marketedelivery.camada.exceptions.ClienteInexistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoExistenteException;
import br.com.marketedelivery.camada.exceptions.ProdutoInexistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoExistenteException;
import br.com.marketedelivery.camada.exceptions.SupermercadoInexistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioExistenteException;
import br.com.marketedelivery.camada.exceptions.UsuarioInxistenteException;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorCliente;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorProduto;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorSupermercado;
import br.com.marketedelivery.camada.interfaces.negocio.IControladorUsuario;
import br.com.marketedelivery.camada.interfaces.negocio.IFachada;

public class Fachada implements IFachada
{
	private IFachada instancia;

	private IControladorCliente controladorCliente;

	private IControladorSupermercado controladorSupermercado;

	private IControladorProduto controladorProduto;

	private IControladorUsuario controladorUsuario;

	public Fachada()
	{
		this.controladorCliente = new ControladorCliente();
		this.controladorSupermercado = new ControladorSupermercado();
		this.controladorProduto = new ControladorProduto();
		this.controladorUsuario = new ControladorUsuario();
	}

	public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException
	{
		controladorCliente.cadastrarCliente(cliente);
	}

	public void alterarCliente(Cliente cliente) throws ClienteInexistenteException
	{
		controladorCliente.alterarCliente(cliente);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#excluirCliente(br.com.
	 * marketedelivery.camada.classesBasicas.Cliente)
	 */
	@Override
	public void excluirCliente(Cliente cliente) throws ClienteInexistenteException
	{
		// controladorCliente.excluir(cliente);
	}

	public List<Cliente> consultarTodosClientes() throws ClienteInexistenteException
	{
		return controladorCliente.consultarTodosClientes();
	}

	public Cliente pesquisarCliente(String cpf) throws ClienteInexistenteException
	{
		return controladorCliente.pesquisarCliente(cpf);
	}

	@Override
	public void cadastrarSupermercado(Supermercado Supermercado) throws SupermercadoExistenteException
	{
		controladorSupermercado.cadastrarSupermercado(Supermercado);
	}

	@Override
	public void excluirSupermercado(Supermercado Supermercado) throws SupermercadoInexistenteException
	{
		controladorSupermercado.excluirSupermercado(Supermercado);
	}

	@Override
	public void alterarSupermercado(Supermercado Supermercado) throws SupermercadoInexistenteException
	{
		controladorSupermercado.alterarSupermercado(Supermercado);
	}

	@Override
	public Supermercado pesquisarSupermercadoPorCnpj(String cnpj) throws SupermercadoInexistenteException
	{
		return controladorSupermercado.pesquisarSupermercadoPorCnpj(cnpj);
	}

	@Override
	public Supermercado pesquisarSupermercadoPorCodigo(int codigo_pessoa) throws SupermercadoInexistenteException
	{
		return controladorSupermercado.pesquisarSupermercadoPorCodigo(codigo_pessoa);
	}

	@Override
	public List<Supermercado> consultarTodosSupermercados() throws SupermercadoInexistenteException
	{
		return controladorSupermercado.consultarTodosSupermercados();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#CadastrarProduto(br.com
	 * .marketedelivery.camada.classesBasicas.Produto)
	 */
	@Override
	public void cadastrarProduto(Produto produto) throws ProdutoExistenteException
	{
		controladorProduto.cadastrarProduto(produto);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#alterarProduto(br.com.
	 * marketedelivery.camada.classesBasicas.Produto)
	 */
	@Override
	public void alterarProduto(Produto produto) throws ProdutoInexistenteException
	{
		controladorProduto.alterarProduto(produto);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#excluirProduto(br.com.
	 * marketedelivery.camada.classesBasicas.Produto)
	 */
	@Override
	public void excluirProduto(Produto produto) throws ProdutoInexistenteException
	{
		// controladorProduto.excluirProduto(produto);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#listarTodososProduto()
	 */
	@Override
	public List<Produto> consultarTodosProdutos() throws ProdutoInexistenteException
	{
		return controladorProduto.consultarTodosProdutos();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#pesquisarProduto(java.
	 * lang.String)
	 */
	@Override
	public Produto pesquisarProduto(String nome) throws ProdutoInexistenteException
	{
		return controladorProduto.pesquisarProduto(nome);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#pesquisarProdutoPorId(
	 * int)
	 */
	@Override
	public Produto pesquisarProdutoPorId(int codigo) throws ProdutoInexistenteException
	{
		return controladorProduto.pesquisarProdutoPorId(codigo);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#CadastrarUsuario(br.com
	 * .marketedelivery.camada.classesBasicas.Usuario)
	 */
	@Override
	public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException
	{
		controladorUsuario.cadastrarUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#alterarUsuario(br.com.
	 * marketedelivery.camada.classesBasicas.Usuario)
	 */
	@Override
	public void alterarUsuario(Usuario usuario) throws UsuarioInxistenteException
	{
		controladorUsuario.alterarUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#excluirUsuario(br.com.
	 * marketedelivery.camada.classesBasicas.Usuario)
	 */
	@Override
	public void excluirUsuario(Usuario usuario) throws UsuarioInxistenteException
	{
		// controladorUsuario.excluir(usuario);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * br.com.marketedelivery.camada.interfaces.IFachada#listarTodosUsuario()
	 */
	@Override
	public List<Usuario> consultarTodosUsuarios() throws UsuarioInxistenteException
	{
		return controladorUsuario.consultarTodosUsuarios();
	}

	// Gets e Sets
	public IFachada getInstancia()
	{
		if (instancia == null)
		{
			instancia = new Fachada();
		}
		return instancia;
	}
}