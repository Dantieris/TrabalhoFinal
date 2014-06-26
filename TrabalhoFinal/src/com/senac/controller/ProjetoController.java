package com.senac.controller;
import com.senac.model.Issue;
import com.senac.view.*;
import com.senac.model.Projeto;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.exceptions.ItemNaoEncontradoException;
import com.senac.lib.exceptions.ListaVaziaException;
public class ProjetoController {
	private Projeto projeto;
	private UsuarioController userControll;
	private ListaOrdenada<Projeto> listaDeProjetos;
	private ProjetoView pview;
	
	public ProjetoController(){
		this.listaDeProjetos = new ListaOrdenada<Projeto>();
		this.pview = new ProjetoView();
	}
	
	/**
	 * Insere um projeto na lista de projetos
	 * @param projeto a ser inserido
	 */
	public void addProjeto(Projeto projeto){
		this.listaDeProjetos.inserir(projeto);
	}

	/**
	 * Busca um projeto na lista de projetos
	 * @param projeto
	 * @return o projeto caso encontre, caso nao encontre retorna uma mensagem, caso a lista esteja vazia, retorna uma mensagem
	 * em todos os outros casos retorna null
	 */
	public Projeto getProjeto(Projeto projeto) {
		try {
			return this.listaDeProjetos.procura(projeto).getValor();
		} catch (ListaVaziaException e) {
			this.pview.exibir("A lista de Projetos se encontra vazia.");
			//e.printStackTrace();
		} catch (ItemNaoEncontradoException e) {
			this.pview.exibir("Infelizmente nao foi possivel encontrar o projeto.");
			//e.printStackTrace();
		}
		return null;				
	}

	/**
	 * Remove um projeto da lista de projetos.
	 * @param proj projeto a ser removido
	 * caso nao consiga remover exibe uma mensagem explicando o motivo:
	 * Lista vazia ou Projeto nao encontrado.
	 */
	public void remove(Projeto proj) {
		try {
			this.listaDeProjetos.remover(proj);			
		} catch (ListaVaziaException e) {
			this.pview.exibir("A lista de Projetos se encontra vazia.");			
			//e.printStackTrace();
		} catch (ItemNaoEncontradoException e) {
			this.pview.exibir("Infelizmente nao foi possivel encontrar o projeto.");			
			//e.printStackTrace();
		}					
	}
	
	
}
