package com.senac.lib;

/**
 * Este enum representa objetos dos níveis de criticidade de uma Issue.
 */
public enum Criticidade {
	
	BLOCKER("BLOCKER"),
	CRITICAL("CRITICAL"),
	HIGH("HIGH"),
	MEDIUM("MEDIUM"),
	LOW("LOW");
	
	private String descricao;
	
	private Criticidade(String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Acessa a descrição da criticidade.
	 * @return A descrição.
	 */
	public String getDescricao(){
		return this.descricao;
	}
	
}
