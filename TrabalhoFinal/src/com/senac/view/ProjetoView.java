package com.senac.view;

public class ProjetoView extends ConsoleView {

	public void exibirIdProjeto(int idProjeto){
		this.exibir("Projeto ID: " + idProjeto);
	}
	
	public void exibirNomeProjeto(String nomeProjeto){
		this.exibir("Nome do Projeto: " + nomeProjeto);
	}
	
	public void exibirDescricaoProjeto(String descricao){
		this.exibir("Descricao: "+ descricao);
	}
		
	public void exibirCriadorProjeto(String criador){
		this.exibir("Criador: " + criador); 
	}
	
	public void exibirTituloListaProjetos(){
		this.exibir("- - - - - - - - - - -  - - - ");
		this.exibir("Lista de Projetos: ");
	}
	
}
