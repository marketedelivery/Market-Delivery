package br.com.marketedelivery.camada.dados;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public abstract class GenericDaoImpl<Entity> implements GenericDao<Entity>, Serializable
{
	private static final long serialVersionUID = 1L;

	protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("db_marketDelivery");

	protected EntityManager em;

	protected Class<Entity> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl()
	{
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		persistentClass = (Class<Entity>) parameterizedType.getActualTypeArguments()[0];
	}

	public void inicializaTransaction()
	{
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public void commit()
	{
		em.getTransaction().commit();
	}

	public void rollback()
	{
		em.getTransaction().rollback();
	}

	public void finalizaTransaction()
	{
		em.close();
	}

	public void commitEfinalizaTransaction()
	{
		commit();
		finalizaTransaction();
	}

	public void flush()
	{
		em.flush();
	}

	public void joinTransaction()
	{
		em = emf.createEntityManager();
		em.joinTransaction();
	}

	public void salva(Entity entity)
	{
		em.persist(entity);
	}

	public void delete(Object id, Class<Entity> classe)
	{
		Entity entityToBeRemoved = em.getReference(classe, id);
		em.remove(entityToBeRemoved);
	}

	public Entity atualiza(Entity entity)
	{
		return em.merge(entity);
	}

	public Entity busca(Integer entityID)
	{
		return em.find(persistentClass, entityID);
	}

	public List<Entity> lista()
	{
		String sql = "from " + persistentClass.getSimpleName();
		TypedQuery<Entity> query = em.createQuery(sql, persistentClass);
		return query.getResultList();
	}

	@SuppressWarnings("unused")
	private void populateQueryParameters(Query query, Map<String, Object> parameters)
	{
		for (Entry<String, Object> entry : parameters.entrySet())
		{
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}
