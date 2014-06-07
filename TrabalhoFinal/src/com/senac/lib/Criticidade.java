package com.senac.lib;

/**
 * Este enum representa objetos dos n�veis de criticidade de uma Issue.
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
	 * Acessa a descri��o da criticidade.
	 * @return A descri��o.
	 */
	public String getDescricao(){
		return this.descricao;
	}
	
}
