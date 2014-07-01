package com.senac.controller;

import com.senac.controller.*;
import com.senac.view.*;
public class Controller {

	private ConsoleView cv;
	private UsuarioController uc;
	private ProjetoController pc;
	
	
	public Controller(){
		this.cv = new ConsoleView();
		this.uc = new UsuarioController();
		this.pc = new ProjetoController(this.uc);
		this.inicia();
	}
	
	
	private void inicia(){
		this.logarUsuario();
		
		this.pc.exibirTodosProjetos();
		this.gerenciarMenu();		
	}
		
	
	private void logarUsuario(){		
		this.uc.getUsuarioView().printTelaCadastro();
		String nome = this.uc.getUsuarioView().printName();
		String username = this.uc.getUsuarioView().printUsername();
		String senha = this.uc.getUsuarioView().printSenha();
		this.uc.cadastrar(nome, username, senha);				
		this.cv.exibir("Usuario logado: " + this.uc.getUsuarioLogado().getNome());
	}
	
	private void gerenciarMenu(){
		int opcao;
		do{
			opcao = this.menuProjetos();
			this.tratarEscolhaProjetos(opcao);
		}while(opcao != 0);
	}
	
	private int menuProjetos(){
		this.cv.exibir("0 - Sair.");
		this.cv.exibir("1 - Adicionar novo projeto.");
		this.cv.exibir("2 - Editar Projeto Existente. ");
		this.cv.exibir("3 - Exibir Projetos Existente. ");
		return Integer.parseInt(this.cv.receber());
	}
	
	private void tratarEscolhaProjetos(int escolha){
		switch(escolha){
			case 1:
				this.pc.preencherNovoProjeto();
				break;
			case 3:
				cv.exibir("opcao exibir todos os projetos!");
				this.pc.exibirTodosProjetos();
				break;
			case 0:
				this.cv.exibir("Deslogando...");
				break;
			default:
				this.cv.exibir("Opcao invalida");				
				break;
		}
	}
}
