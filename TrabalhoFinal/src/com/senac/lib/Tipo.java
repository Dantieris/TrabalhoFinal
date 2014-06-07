package com.senac.lib;

/**
 * Este enum representa objetos dos tipos de uma Issue.
 */
public enum Tipo {
	
	BUG("BUG"),
	ENHANCEMENT("ENHANCEMENT");
	
	private String descricao;
	
	private Tipo(String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Acessa a descri��o do Tipo.
	 * @return A descri��o.
	 */
	public String getDescricao(){
		return this.descricao;
	}
}
