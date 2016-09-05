package br.com.marketedelivery.camada.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteHttp
{
	private int codigo;

	private String nome;

	private String rg;

	private String cpf;

	private String telefone;

	private String celular;

	private String email;

	private Endereco endereco;

	public ClienteHttp()
	{
		this.nome = "";
		this.rg = "";
		this.cpf = "";
		this.telefone = "";
		this.celular = "";
		this.email = "";
		this.endereco = new Endereco();
	}

	public ClienteHttp(int codigo, String nome, String rg, String cpf, String telefone, String celular, String email,
			Endereco endereco)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
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

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getCelular()
	{
		return celular;
	}

	public void setCelular(String celular)
	{
		this.celular = celular;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Endereco getEndereco()
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}
}