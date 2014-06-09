package com.senac.model;

import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Status;
import com.senac.lib.Tipo;
import com.senac.lib.Vetor;

public class Issue implements Comparable<Issue> {

	private String titulo;
	private String descricao;
	private int dataCriacao;
	private Criticidade criticidade;
	private Tipo tipo;
	private Status status;
	private Usuario criado;
	private Vetor<Evento> eventos;
	
	/**
	 * Inicializa um objeto Issue recém-criado com titulo, descricao, criticidade e tipo, definidos por parâmetros.
	 * 
	 * @param titulo O titulo da issue.
	 * @param descricao A descrição da issue.
	 * @param criticidade A criticidade da issue.
	 * @param tipo O tipo da issue.
	 */
	public Issue( String titulo, String descricao, Criticidade criticidade, Tipo tipo, int dataCriacao) {
		this.titulo 	 = titulo;
		this.descricao 	 = descricao;
		this.criticidade = criticidade;
		this.tipo 		 = tipo;
		this.dataCriacao = dataCriacao;
		this.status		 = status.NOVO;
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
	
	public Vetor<Evento> getListaEventos() { return eventos; }
	
	/**
	 * Implementa uma comparação por criticidade de issues. 
	 * Retornando maior que 1 se esta issue é maior, 
	 * retorna 0 se for igual e menor que 1 se for menor.
	 * 
	 * @return O resultado da comparação.
	 */
	@Override
	public int compareTo(Issue issue) {
		if ( this.criticidade.getNivel() < issue.getCriticidade().getNivel() ) {
			return -1;
		}
		if ( this.criticidade.getNivel() > issue.getCriticidade().getNivel() ) {
			return 1;
		}
		
		return 0;
	}
	
}
