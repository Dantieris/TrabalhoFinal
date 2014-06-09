package com.senac.model;

/**
 * Classe que representa um Evento (Cadastro de Issue, 
 * atualizacao de situa��o, etc). 
 * Como funciona apenas como reposit�rio de informa��es
 * n�o cont�m Testes.
 */
public class Evento {

	private int dataCriacao;
	private String comentario;
	private Usuario usuario;
	
	/**
	 * Construtor da classe Evento. Quando um novo evento for
	 * ser criado, ser� necess�rio que o mesmo receba a data em que foi criado
	 * o comentario do evento e o usuario que criou o evento
	 * obs.: A data/hora ser� fornecida automaticamente (controller) conforme
	 * a hora atual do sistema. 
	 * @param dataCriacao
	 * @param comentario
	 * @param usuario
	 */
	public Evento(int dataCriacao, String comentario, Usuario usuario){
		this.setDataCriacao(dataCriacao);
		this.setComentario(comentario);
		this.setUsuario(usuario);
	}
	
	//Metodos Acessores
	public int getDataCriacao() {
		return dataCriacao;
	}
	private void setDataCriacao(int dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
}
