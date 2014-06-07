package com.senac.lib;

/**
 * Este enum representa objetos dos estados de uma Issue.
 */
public enum Status {	
	
	NOVO("NOVO"),
	ABERTO("ABERTO"),
	EM_DEV("EM DESENVOLVIMENTO"),
	CLOSED("CLOSED"),
	DUPLICADO("DUPLICADO"),
	ATRIBUIDO("ATRIBUIDO"),
	WONT_FIX("WONT FIX");
	
	private String descricao;
	
	private Status(String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Acessa a descrição do Status.
	 * @return A descrição.
	 */
	public String getDescricao(){
		return this.descricao;
	}
}
