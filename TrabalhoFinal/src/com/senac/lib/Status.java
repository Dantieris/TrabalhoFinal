package com.senac.lib;

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
	
	public String getDescricao(){
		return this.descricao;
	}
}
