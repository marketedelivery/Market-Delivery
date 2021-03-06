package br.com.marketedelivery.camada.http;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.marketedelivery.camada.classesBasicas.Categoria;
import br.com.marketedelivery.camada.classesBasicas.Marca;
import br.com.marketedelivery.camada.classesBasicas.Status;
import br.com.marketedelivery.camada.classesBasicas.Supermercado;
import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;

@XmlRootElement
public class ProdutoHttp
{
	private Integer codigo;

	private String nome;

	private String descricao;

	private Marca marca;

	private UnidadeMedida UnidadeMedida;

	private int peso;

	private int quantidade;

	private String informaçãoNutricional;

	private Calendar dataValidade;

	private Status status;

	private Categoria categoria;

	private Supermercado supermercado;

	// Construtores
	public ProdutoHttp()
	{
		this.nome = "";
		this.descricao = "";
		this.descricao = "";
		this.marca = new Marca();
		this.UnidadeMedida = new UnidadeMedida();
		this.informaçãoNutricional = "";
		this.dataValidade = Calendar.getInstance();
		this.status = Status.ATIVO;
		this.categoria = new Categoria();
		this.supermercado = new Supermercado();
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @param marca
	 * @param unidadeMedida
	 * @param peso
	 * @param quantidade
	 * @param informaçãoNutricional
	 * @param dataValidade
	 * @param status
	 * @param categoria
	 * @param supermercado
	 */
	public ProdutoHttp(Integer codigo, String nome, String descricao, Marca marca, UnidadeMedida unidadeMedida,
			int peso, int quantidade, String informaçãoNutricional, Calendar dataValidade, Status status,
			Categoria categoria, Supermercado supermercado)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		UnidadeMedida = unidadeMedida;
		this.peso = peso;
		this.quantidade = quantidade;
		this.informaçãoNutricional = informaçãoNutricional;
		this.dataValidade = dataValidade;
		this.status = status;
		this.categoria = categoria;
		this.supermercado = supermercado;
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

	public Marca getMarca()
	{
		return marca;
	}

	public void setMarca(Marca marca)
	{
		this.marca = marca;
	}

	public UnidadeMedida getUnidadeMedida()
	{
		return UnidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida)
	{
		this.UnidadeMedida = unidadeMedida;
	}

	public int getPeso()
	{
		return peso;
	}

	public void setPeso(int peso)
	{
		this.peso = peso;
	}

	public int getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}

	public String getInformaçãoNutricional()
	{
		return informaçãoNutricional;
	}

	public void setInformaçãoNutricional(String informaçãoNutricional)
	{
		this.informaçãoNutricional = informaçãoNutricional;
	}

	public Calendar getDataValidade()
	{
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade)
	{
		this.dataValidade = dataValidade;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

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
	 * @return the supermercado
	 */
	public Supermercado getSupermercado()
	{
		return supermercado;
	}

	/**
	 * @param supermercado
	 *            the supermercado to set
	 */
	public void setSupermercado(Supermercado supermercado)
	{
		this.supermercado = supermercado;
	}
}