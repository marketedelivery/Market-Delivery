package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.classebasica.Cliente;
import br.com.marketedelivery.classebasica.Supermercado;

public class Fachada implements IFachada
{
	 private IFachada instancia;
	 private ControladorCliente controladorCliente;
	 private ControladorSupermercado controladorSupermercado;
	    
	    public  IFachada getInstancia()
	    {
	        if (instancia == null)
	        {
	            instancia = new Fachada();
	        }
	        return instancia;
	    }
	    
	    public Fachada()
	    {
	        this.controladorCliente = new ControladorCliente();
	        this.controladorSupermercado = new ControladorSupermercado();
	    }
	    
	    public void CadastrarCliente(Cliente cliente)
	    {
	    	controladorCliente.cadastrarCliente(cliente);
	    }
	    
	    public void atualizar(Cliente cliente)
	    {
	    	controladorCliente.atualizarCliente(cliente);
	    }
	    
	    public List<Cliente> listarTodososClientes()
	    {
	    	return controladorCliente.listarCliente();
	    }
	    
	    public Cliente pesquisarCliente(String cpf)
	    {
	    	return controladorCliente.pesquisarCliente(cpf);
	    }
	    
	    

	    @Override
	    public void cadastrarSupermercado(Supermercado Supermercado)
	    {
	        controladorSupermercado.cadastrarSupermercado(Supermercado);
	    }
	    
	    @Override
	    public void excluirSupermercado(Supermercado Supermercado)
	    {
	        controladorSupermercado.excluirSupermercado(Supermercado);
	    }
	    
	    @Override
	    public void alterarSupermercado(Supermercado Supermercado)
	    {
	        controladorSupermercado.alterarSupermercado(Supermercado);
	    }
	    
	    @Override
	    public Supermercado pesquisarCpfCnpj(String cpf_cnpj)
	    {
	        return controladorSupermercado.pesquisarSupermercado(cpf_cnpj);
	    }
	    
	    @Override
	    public Supermercado pesquisarPorCodigo(int codigo_pessoa) {
	        return controladorSupermercado.pesquisarSupermercadoPorCodigo(codigo_pessoa);
	    }
	        
	    @Override
	    public List<Supermercado>listarTodosSupermercados()
	    {
	        return controladorSupermercado.listarTodosSupermercados();
	    }
	    
}
