package br.com.marketedelivery.camada.interfaces.negocio;

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
import br.com.marketedelivery.camada.exceptions.UsuarioInexistenteException;

public interface IFachada
{
	// Cliente
	public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException;

	public void alterarCliente(Cliente cliente) throws ClienteInexistenteException;

	public void excluirCliente(Cliente cliente) throws ClienteInexistenteException;

	public List<Cliente> consultarTodosClientes() throws ClienteInexistenteException;

	public Cliente pesquisarCliente(String cpf) throws ClienteInexistenteException;

	// Supermercado
	public void cadastrarSupermercado(Supermercado Supermercado) throws SupermercadoExistenteException;

	public void alterarSupermercado(Supermercado Supermercado) throws SupermercadoInexistenteException;

	public void excluirSupermercado(Supermercado Supermercado) throws SupermercadoInexistenteException;

	public Supermercado pesquisarSupermercadoPorCnpj(String cnpj) throws SupermercadoInexistenteException;

	public Supermercado pesquisarSupermercadoPorId(int codigo) throws SupermercadoInexistenteException;

	public List<Supermercado> consultarTodosSupermercados() throws SupermercadoInexistenteException;

	// Produtos
	public void cadastrarProduto(Produto produto) throws ProdutoExistenteException;

	public void alterarProduto(Produto produto) throws ProdutoInexistenteException;

	public void excluirProduto(Produto produto) throws ProdutoInexistenteException;

	public List<Produto> consultarTodosProdutos() throws ProdutoInexistenteException;

	public Produto pesquisarProduto(String nome) throws ProdutoInexistenteException;

	public Produto pesquisarProdutoPorId(int codigo) throws ProdutoInexistenteException;

	// Usuarios
	public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException;

	public void alterarUsuario(Usuario usuario) throws UsuarioInexistenteException;

	public void excluirUsuario(Usuario usuario) throws UsuarioInexistenteException;

	public List<Usuario> consultarTodosUsuarios() throws UsuarioInexistenteException;
}