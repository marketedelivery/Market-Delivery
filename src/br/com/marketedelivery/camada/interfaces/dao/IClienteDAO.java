package br.com.marketedelivery.camada.interfaces.dao;

import br.com.marketedelivery.camada.classesBasicas.Cliente;

public interface IClienteDAO extends IDAOGenerico<Cliente>
{
	public Cliente buscarClientePorCPF(String cpf);
}