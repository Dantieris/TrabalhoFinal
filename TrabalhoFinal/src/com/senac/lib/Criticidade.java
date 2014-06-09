package com.senac.lib;

/**
 * Este enum representa objetos dos níveis de criticidade de uma Issue.
 */
public enum Criticidade {
	
	BLOCKER("BLOCKER", 5),
	CRITICAL("CRITICAL", 4),
	HIGH("HIGH", 3),
	MEDIUM("MEDIUM", 2),
	LOW("LOW", 1);
	
	private String descricao;
	private int nivel;
	
	private Criticidade(String descricao, int nivel){
		this.descricao = descricao;
		this.nivel = nivel;
	}
	
	/**
	 * Acessa a descrição da criticidade.
	 * @return A descrição.
	 */
	public String getDescricao(){
		return this.descricao;
	}
	
	public int getNivel(){
		return this.nivel;
	}
}
