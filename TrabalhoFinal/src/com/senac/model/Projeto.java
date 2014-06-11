package com.senac.model;

import com.senac.model.Usuario;
import com.senac.lib.Vetor;
import com.senac.lib.ListaOrdenada;

public class Projeto implements Comparable<Projeto> {
	
	private Usuario criador;
	private Vetor<Usuario> desenvolvedor;
	private String nome;
	private String descricao;
 	private ListaOrdenada<Issue> issue;
	
 	/**
 	 * Novos objetos Projeto sempre terã:o Criador, nome do projeto, descrição do projeto
 	 * e um vetor de desenvolvedores (iniciando em zero).
 	 * @param criador:Usuario (dono do projeto)
 	 * @param nome:String (nome do projeto)
 	 * @param descricao:String (descrição do projeto)
 	 */
 	public Projeto(Usuario criador, String nome, String descricao){
 		this.setCriador(criador);
 		this.setNome(nome);
 		this.setDescricao(descricao);
 		this.desenvolvedor = new Vetor<>(0);
 	}
 	
 	public void addDesenvolvedor(Usuario desenvolvedor){
 		this.desenvolvedor.put(0, desenvolvedor);
 	}
 	
 	/**
 	 * Busca um desenvolvedor em uma posição especifica do vetor.
 	 * @param indice
 	 * @return desenvolvedor(Usuario.class) a que o indice faz referência.
 	 */
 	public Usuario getDesenvolvedor(int indice){
 		return this.desenvolvedor.get(indice);
 	}
 	
	public int compareTo(Projeto proj){
		return 0;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
