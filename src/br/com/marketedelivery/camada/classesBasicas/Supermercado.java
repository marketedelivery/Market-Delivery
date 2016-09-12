package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_supermercado")
public class Supermercado
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(name = "supmerc_nome", length = 50, nullable = true)
	private String nome;

	@Column(length = 14, nullable = false, unique = true)
	private String cnpj;

	@Column(nullable = false)
	private String inscricaoEstatdual;

	@Column(name = "telefone", length = 11)
	private String telefone;

	@Column(name = "supmerc_email", length = 50, nullable = true)
	private String email;

	@Column(name = "supmerc_estoque", length = 5, nullable = true)
	private int estoque;

	@Column(name = "supermercado_preco_produto", length = 6, nullable = false)
	private double preco_Produto;

	// Falta colocar o preço do produto referente a cada produto
	public Supermercado()
	{
		super();
		this.nome = "";
		this.cnpj = "";
		this.inscricaoEstatdual = "";
		this.telefone = "";
		this.email = "";
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param cnpj
	 * @param inscricaoEstatdual
	 * @param telefone
	 * @param email
	 * @param estoque
	 * @param preco_Produto
	 */
	public Supermercado(int codigo, String nome, String cnpj, String inscricaoEstatdual, String telefone, String email,
			int estoque, double preco_Produto)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEstatdual = inscricaoEstatdual;
		this.telefone = telefone;
		this.email = email;
		this.estoque = estoque;
		this.preco_Produto = preco_Produto;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
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

	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	public String getInscricaoEstatdual()
	{
		return inscricaoEstatdual;
	}

	public void setInscricaoEstatdual(String inscricaoEstatdual)
	{
		this.inscricaoEstatdual = inscricaoEstatdual;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getEstoque()
	{
		return estoque;
	}

	public void setEstoque(int estoque)
	{
		this.estoque = estoque;
	}

	/**
	 * @return the preco_Produto
	 */
	public double getPreco_Produto()
	{
		return preco_Produto;
	}

	/**
	 * @param preco_Produto
	 *            the preco_Produto to set
	 */
	public void setPreco_Produto(double preco_Produto)
	{
		this.preco_Produto = preco_Produto;
	}

	@Override
	public String toString()
	{
		return "Supermercado [codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj + ", inscricaoEstatdual="
				+ inscricaoEstatdual + ", telefone=" + telefone + ", email=" + email + ", estoque=" + estoque + "]";
	}
}