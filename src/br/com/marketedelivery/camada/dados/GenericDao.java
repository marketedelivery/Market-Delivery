package br.com.marketedelivery.camada.dados;

import java.util.List;

public interface GenericDao<Entity>
{
	public void salva(Entity entity);

	public Entity atualiza(Entity entity);

	public void delete(Object id, Class<Entity> classe);

	// public Entity findById(Integer id);
	public List<Entity> lista();
}