package br.com.marketedelivery.camada.negocio;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.marketedelivery.camada.dados.ClienteDao;
import br.com.marketedelivery.camada.dados.DaoFactory;
import br.com.marketedelivery.camada.dados.IClienteDao;
import br.com.marketedelivery.classebasica.Cliente;

public class ControladorCliente 
{
	private IClienteDao clienteDao;
	
	
	public void cadastrarCliente(Cliente cliente)
	{
		Cliente cli = clienteDao.buscarClientePorCPF(cliente.getCpf());
		if (cli == null)
		{
			clienteDao = new DaoFactory().getClienteDao();
			clienteDao.inserir(cliente);
		}else
		{
			JOptionPane.showMessageDialog(null, "CPF j� cadastrado no sistema", "Aten��o", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void atualizarCliente(Cliente cliente)
	{
		clienteDao = new DaoFactory().getClienteDao();
		clienteDao.alterar(cliente);
		
	}
	public List<Cliente>listarCliente()
	{
		clienteDao = new DaoFactory().getClienteDao();
		return clienteDao.consultarTodos();
	}
	public Cliente pesquisarCliente(String cpf)
	{
		clienteDao = new DaoFactory().getClienteDao();
		Cliente cli = clienteDao.buscarClientePorCPF(cpf);
		if(cli == null)
		{
			JOptionPane.showMessageDialog(null, "Nenhum Cadastro encontrado","Aten��o",JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else
		{
			return cli;
		}
	}
}
