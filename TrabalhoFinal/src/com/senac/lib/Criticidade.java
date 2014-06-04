package com.senac.lib;

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
	
	public String getDescricao(){
		return this.descricao;
	}
	
}
