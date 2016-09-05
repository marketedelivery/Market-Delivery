package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto
{
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "nome_produto", length = 50, nullable = false)
	private String nome;

	@Column(name = "descricao_produto", length = 150, nullable = false)
	private String descricao;

	public Produto()
	{
		this.nome = "";
		this.descricao = "";
	}

	public Produto(String nome, String descricao)
	{
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}