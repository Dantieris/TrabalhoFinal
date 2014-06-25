package com.senac.controller;
import com.senac.model.Issue;
import com.senac.model.Projeto;
import com.senac.lib.ListaOrdenada;
public class ProjetoController {
	private Projeto projeto;
	private UsuarioController userControll;
	private ListaOrdenada<Projeto> listaDeProjetos;
	
	public ProjetoController(){
		
	}
	
	/**
	 * Insere um projeto na lista de projetos
	 * @param projeto a ser inserido
	 */
	public void addProjeto(Projeto projeto){
		this.listaDeProjetos.inserir(projeto);
	}
}
