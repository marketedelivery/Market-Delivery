package br.com.marketedelivery.camada.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SupermercadoHttp
{
	private int codigo;

	private String nome;

	private String cnpj;

	private String inscricaoEstatdual;

	private String telefone;

	private String email;

	private int estoque;

	public SupermercadoHttp()
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
	 */
	public SupermercadoHttp(int codigo, String nome, String cnpj, String inscricaoEstatdual, String telefone, String email,
			int estoque)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEstatdual = inscricaoEstatdual;
		this.telefone = telefone;
		this.email = email;
		this.estoque = estoque;
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
}