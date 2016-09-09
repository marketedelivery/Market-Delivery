package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Usuario;
import br.com.marketedelivery.camada.dados.IUsuarioDao;
import br.com.marketedelivery.camada.dados.UsuarioDao;


public class UsuarioDao extends DAOGenerico<Usuario> implements IUsuarioDao{

	private EntityManager manager;
	
	public UsuarioDao(EntityManager em) {
		super(em);
		this.manager = em;
		// TODO Auto-generated constructor stub
	}

	/**
	 * faz a validação do usuario na base de dados
	 * @see br.com.marketedelivery.camada.dados.IUsuarioDao#validarUsuario(br.com.marketedelivery.classebasica.Usuario)
	 */
	public Usuario validarUsuario(Usuario us){
		EntityTransaction tx = getEntityManager().getTransaction();
		try{
		String sql = "SELECT us FROM Usuario HHERE us.email = :email and us.senha = :senha";
		TypedQuery<Usuario> queryUsuario = this.entityManager.createQuery(sql, Usuario.class);
		queryUsuario.setParameter("email", us.getEmail());
		queryUsuario.setParameter("senha", us.getSenha());
		us = queryUsuario.getSingleResult();
		return us;
		}catch(Exception e){
			if(tx != null && tx.isActive()){
				tx.rollback();
			}
		}
		return null;
	}

	@Override
	public void inserirUsuario(Usuario us) {
		// TODO Auto-generated method stub
		
	}
}
