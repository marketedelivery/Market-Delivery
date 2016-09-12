/**
 * 
 */
package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Categoria
{
	// Atributos
	@Id
	@GeneratedValue
	private Integer codigo;

	@ManyToOne
	private Categoria categoria;

	@Column(name = "nome_categoria", length = 25, nullable = false)
	private String nome;
	// Construtores

	public Categoria()
	{
		this.categoria = null;
		this.nome = "";
	}

	/**
	 * @param categoria
	 * @param nome
	 */
	public Categoria(Categoria categoria, String nome)
	{
		super();
		this.categoria = categoria;
		this.nome = nome;
	}

	// Gets e Sets
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria()
	{
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
}