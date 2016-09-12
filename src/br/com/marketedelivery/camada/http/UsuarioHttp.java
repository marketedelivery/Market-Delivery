package br.com.marketedelivery.camada.http;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.marketedelivery.camada.classesBasicas.Status;

@XmlRootElement
public class UsuarioHttp
{
	// Atributos
	private Integer codigo;

	private String email;

	private String senha;

	private Status status;

	// Construtores
	public UsuarioHttp()
	{
		this.email = "";
		this.senha = "";
		this.status = Status.ATIVO;
	}

	/**
	 * @param codigo
	 * @param email
	 * @param senha
	 */
	public UsuarioHttp(Integer codigo, String email, String senha, Status status)
	{
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}

	// Gets e Sets
	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}
}