package com.senac.model;

/**
 * Classe representa um usuario do sistema.
 * Como funciona apenas como repositório de informações
 * não contém Testes.
 */
public class Usuario {

	private String nome;
	private String username;
	private String senha;
	
	/**
	 * Construtor da classe Usuario. Quando um novo usuario for 
	 * ser instanciado é necessário que se informe um nome, username
	 * e senha.
	 * @param nome
	 * @param username
	 * @param senha
	 */
	public Usuario(String nome, String username, String senha){
		this.setNome(nome);
		this.setUsername(username);
		this.setSenha(senha);
	}

	//Abaixo métodos acessores.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
