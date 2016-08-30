package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.classebasica.Cliente;
import br.com.marketedelivery.classebasica.Supermercado;

public interface IFachada
{
	public void CadastrarCliente(Cliente cliente);
	public void atualizar(Cliente cliente);
	public List<Cliente> listarTodososClientes();
	public Cliente pesquisarCliente(String cpf);
	
	
    public void cadastrarSupermercado(Supermercado Supermercado);
    public void excluirSupermercado(Supermercado Supermercado);
    public void alterarSupermercado(Supermercado Supermercado);
    public Supermercado pesquisarCpfCnpj(String cpf_cnpj);
    public Supermercado pesquisarPorCodigo(int codigo_pessoa);
    public List<Supermercado> listarTodosSupermercados();
}
