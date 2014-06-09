package com.senac.model;

import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Status;
import com.senac.lib.Tipo;

public class Issue {

	private String titulo;
	private String descricao;
	private int dataCriacao;
	private Criticidade criticidade;
	private Tipo tipo;
	private Status status;
	private Usuario criado;
	private ListaOrdenada<Evento> listaEventos;
	
	/**
	 * Inicializa um objeto Issue recém-criado com titulo, descricao, criticidade e tipo, definidos por parâmetros.
	 * 
	 * @param titulo O titulo da issue.
	 * @param descricao A descrição da issue.
	 * @param criticidade A criticidade da issue.
	 * @param tipo O tipo da issue.
	 */
	public Issue( String titulo, String descricao, Criticidade criticidade, Tipo tipo ) {
		this.titulo 	 = titulo;
		this.descricao 	 = descricao;
		this.criticidade = criticidade;
		this.tipo 		 = tipo;
	}
	
	public String getTitulo() { return titulo; }
	
	public void setTitulo(String titulo) { this.titulo = titulo; }
	
	public String getDescricao() { return descricao; }
	
	public void setDescricao(String descricao) { this.descricao = descricao; }
	
	public int getDataCriacao() { return dataCriacao; }
	
	public void setDataCriacao(int dataCriacao) { this.dataCriacao = dataCriacao; }
	
	public Criticidade getCriticidade() { return criticidade; }
	
	public void setCriticidade(Criticidade criticidade) { this.criticidade = criticidade; }
	
	public Tipo getTipo() { return tipo; }
	
	public void setTipo(Tipo tipo) { this.tipo = tipo; }
	
	public Status getStatus() { return status; }
	
	public void setStatus(Status status) { this.status = status; }
	
	public Usuario getCriado() { return criado; }
	
	public void setCriado(Usuario criado) { this.criado = criado; }
	
	public ListaOrdenada<Evento> getListaEventos() { return listaEventos; }
	
}
