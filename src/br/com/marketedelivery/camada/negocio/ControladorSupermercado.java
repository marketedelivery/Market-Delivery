/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marketedelivery.camada.negocio;

import java.util.List;

import br.com.marketedelivery.camada.dados.ISupermercadoDao;
import br.com.marketedelivery.classebasica.Supermercado;


public class ControladorSupermercado 
{
    private ISupermercadoDao supermercadoDao;
 
    public void cadastrarSupermercado(Supermercado supermercado) 
    {
        supermercadoDao = DAOFactory.getSupermercadoDAO();
        Supermercado cli = supermercadoDao.buscarPorCNPJ(supermercado.getCnpj());
        if (cli == null) {
            supermercadoDao.inserir(supermercado);
        } else 
        {
        	
        }
    }

    public void alterarSupermercado(Supermercado supermercado)
    {
        supermercadoDao = DAOFactory.getSupermercadoDAO();
        Supermercado cli = supermercadoDao.buscarPorCNPJ(supermercado.getCnpj());
        if (cli != null) {
            supermercadoDao.alterar(supermercado);
        } 
        else 
        {
        	
        }
      }
  
    public void excluirSupermercado(Supermercado supermercado) 
    {
        supermercadoDao = DAOFactory.getSupermercadoDAO();
        Supermercado cli = supermercadoDao.buscarPorCNPJ(supermercado.getCnpj());
        if (cli != null) {
            supermercadoDao.remover(supermercado);
        } else 
        {

        }
    }

    public Supermercado pesquisarSupermercado(String Cnpj) 
    {
        supermercadoDao = DAOFactory.getSupermercadoDAO();
        Supermercado c = supermercadoDao.buscarPorCNPJ(Cnpj);
        if (c != null)
        {
            return c;
        } else 
        {
           
            return null;
        }
    }

    public Supermercado pesquisarSupermercadoPorCodigo(int codigo) 
    {
        supermercadoDao = DAOFactory.getSupermercadoDAO();
        Supermercado cp = supermercadoDao.consultarPorId(codigo);
        if (cp != null) 
        {
            return cp;
        } else 
        {

            return null;

        }
    }

    public List<Supermercado> listarTodosSupermercados() {
        supermercadoDao = DAOFactory.getSupermercadoDAO();
        return supermercadoDao.consultarTodos();
    }
}
