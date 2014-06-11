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
	
 	
 	public Projeto(Usuario criador, String nome, String descricao){
 		this.setCriador(criador);
 		this.setNome(nome);
 		this.setDescricao(descricao);
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
