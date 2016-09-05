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
	 */
	public Supermercado(int codigo, String nome, String cnpj, String inscricaoEstatdual, String telefone,
			String email, int estoque)
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

	@Override
	public String toString()
	{
		return "Supermercado [codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj + ", inscricaoEstatdual="
				+ inscricaoEstatdual + ", telefone=" + telefone + ", email=" + email + ", estoque=" + estoque + "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Supermercado other = (Supermercado) obj;
		if (cnpj == null)
		{
			if (other.cnpj != null) return false;
		} else if (!cnpj.equals(other.cnpj)) return false;
		if (codigo == null)
		{
			if (other.codigo != null) return false;
		} else if (!codigo.equals(other.codigo)) return false;
		if (email == null)
		{
			if (other.email != null) return false;
		} else if (!email.equals(other.email)) return false;
		if (estoque != other.estoque) return false;
		if (inscricaoEstatdual == null)
		{
			if (other.inscricaoEstatdual != null) return false;
		} else if (!inscricaoEstatdual.equals(other.inscricaoEstatdual)) return false;
		if (nome == null)
		{
			if (other.nome != null) return false;
		} else if (!nome.equals(other.nome)) return false;
		if (telefone == null)
		{
			if (other.telefone != null) return false;
		} else if (!telefone.equals(other.telefone)) return false;
		return true;
	}
}