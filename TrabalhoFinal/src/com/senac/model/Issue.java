package com.senac.model;

import com.senac.lib.Criticidade;
import com.senac.lib.Status;
import com.senac.lib.Tipo;
import com.senac.lib.Vetor;

/**
 * Esta classe representa uma issue, isto �, um problema em um projeto de software, cada issue possui:
 *  t�tulo, descri��o, data de cria��o, criticidade, tipo, status, criador, e um conjunto de eventos.
 */
public class Issue implements Comparable<Issue> {

	private String titulo;
	private String descricao;
	private int dataCriacao;
	private Criticidade criticidade;
	private Tipo tipo;
	private Status status;
	private Usuario criador;
	private Vetor<Evento> eventos;
	private int contadorEventos;
	
	/**
	 * Inicializa um objeto Issue rec�m-criado com as especifica��es titulo, descricao, criticidade e tipo, definidos por par�metros.
	 * @param titulo Uma string com o titulo da issue.
	 * @param descricao Uma string com a descri��o da issue.
	 * @param criticidade Um objeto Criticidade com a criticidade da issue.
	 * @param tipo Um objeto Tipo com o tipo da issue.
	 */
	public Issue( String titulo, String descricao, Criticidade criticidade, Tipo tipo, int dataCriacao) {
		this.titulo 	 = titulo;
		this.descricao 	 = descricao;
		this.criticidade = criticidade;
		this.tipo 		 = tipo;
		this.dataCriacao = dataCriacao;
		this.status		 = Status.NOVO;
		this.eventos 	 = new Vetor<Evento>();
	}
	
	/**
	 * Acessa o t�tulo da issue.
	 * @return Uma string com o t�tulo da issue.
	 */
	public String getTitulo() { return titulo; }
	
	/**
	 * Altera o t�tulo da issue.
	 * @param titulo Uma string que ser� novo t�tulo da issue.
	 */
	public void setTitulo(String titulo) { this.titulo = titulo; }
	
	/**
	 * Acessa a descri��o da issue.
	 * @return Uma string com a descri��o da issue.
	 */
	public String getDescricao() { return descricao; }
	
	/**
	 * Altera a descri��o da issue.
	 * 
	 * @param descricao Uma string com a nova descri��o da issue.
	 */
	public void setDescricao(String descricao) { this.descricao = descricao; }
	
	/**
	 * Acessa a data de cria��o da issue.
	 * @return Um n�mero inteiro com a data de descri��o.
	 */
	public int getDataCriacao() { return dataCriacao; }
	
	/**
	 * Modifica da data de cria��o da issue.
	 * @param dataCriacao Um n�mero inteiro com a nova data de cria��o da issue.
	 */
	public void setDataCriacao(int dataCriacao) { this.dataCriacao = dataCriacao; }
	
	/**
	 * Acessa o objeto criticidade da issue.
	 * 
	 * @return Um objeto Criticidade com a criticidade da issue.
	 */
	public Criticidade getCriticidade() { return criticidade; }
	
	/**
	 * Modifica o objeto criticidade da issue.
	 * @param criticidade Um objecto Criticidade com a nova criticidade da issue.
	 */
	public void setCriticidade(Criticidade criticidade) { this.criticidade = criticidade; }
	
	/**
	 * Acessa o objeto Tipo da issue, que define se o tipo � BUG ou ENHANCEMENT.
	 * @return O objeto atual que determina o tipo da issue.
	 */
	public Tipo getTipo() { return tipo; }
	
	/**
	 * Modifica o tipo da issue. Os tipos s�o: BUG, e ENHANCEMENT.
	 * @param tipo Um objeto Tipo com o novo tipo da issue.
	 */
	public void setTipo(Tipo tipo) { this.tipo = tipo; }
	
	/**
	 * Acessa o status da issue atual.Os status s�o: 
	 * NOVO, ABERTO, EM_DEV, CLOSED, DUPLICADO, ATRIBUIDO, WONT_FIX.
	 * @return Um objeto Status com o estado atual da issue.
	 */
	public Status getStatus() { return status; }
	
	/**
	 * Modifica o status atual da issue. Os status s�o: 
	 * NOVO, ABERTO, EM_DEV, CLOSED, DUPLICADO, ATRIBUIDO, WONT_FIX.
	 * @param status Um objeto Status com o novo status da issue.
	 */
	public void setStatus(Status status) { this.status = status; }
	
	/**
	 * Acessa o usu�rio criador da issue.
	 * @return Um objeto Usuario que criou a issue.
	 */
	public Usuario getCriador() { return criador; }
	
	/**
	 * Modifica o usu�rio criador da issue.
	 * @param criador Um objeto Usuario com o novo criador da issue.
	 */
	public void setCriador(Usuario criador) { this.criador = criador; }
	
	/**
	 * Acessa o vetor de eventos da issue, este vetor cont�m todos os eventos da issue.
	 * @return Um objeto Vetor<Evento> com os eventos da issue.
	 */
	public Vetor<Evento> getEventos() { return eventos; }
	
	/**
	 * Implementa uma compara��o por criticidade de issues. 
	 * Retornando maior que 1 se esta issue � maior, 
	 * retorna 0 se for igual e menor que 1 se for menor.
	 * 
	 * @return O resultado da compara��o.
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

	/**
	 * Adicionado um objeto Evento ao vetor de eventos da issue. 
	 * A adi��o dos eventos depende da integridade da vari�vel contadorEventos.
	 * @param evento Um objeto Evento a ser adicionado.
	 */
	public void add(Evento evento) {
		eventos.put((contadorEventos++), evento);
	}

	/**
	 * Acessa um objeto no vetor de eventos, 
	 * o acesso � feito utilizando o �ndice, o objeto acessado � retornado.
	 * 
	 * @param indice Um n�mero inteiro com o �ndice do evento no vetor.
	 * @return Um objeto Evento do �ndice referido.
	 */
	public Evento getEvento(int indice) {
		return eventos.get(indice);
	}
	
	/**
	 * Transforma as informa��es da issue em uma String.
	 * @return Uma String com as informa��es da issue.
	 */
	public String toString() {
		return (getTitulo() +" "+
				getDescricao() +" - "+ 
				getStatus().getDescricao() +" - "+ 
				getCriticidade().getDescricao() +" - "+ 
				getTipo().getDescricao() +" - "+ 
				getDataCriacao()).replace("[", "").replace("]", "");
	}
}
