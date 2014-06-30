package com.senac.controller;

import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Tipo;
import com.senac.lib.Vetor;
import com.senac.lib.exceptions.ItemNaoEncontradoException;
import com.senac.lib.exceptions.ListaVaziaException;
import com.senac.model.Issue;
import com.senac.model.Projeto;
import com.senac.view.IssueView;

/**
 * 
 *
 */
public class IssueController {

	private ListaOrdenada<Issue> listaDeIssues;
	private IssueView iview;
	
	/**
	 * 
	 */
	public IssueController() {
		this.iview = new IssueView();
		this.listaDeIssues = new ListaOrdenada<Issue>();
	}
	
	/**
	 * 
	 * @param issue
	 */
	public void exibirIssue(Issue issue) {
		iview.exibir(issue.toString());
	}
	
	/**
	 * 
	 * @param issue
	 */
	public void addIssue(Issue issue) {
		this.listaDeIssues.inserir(issue);
	}
	
	/**
	 * 
	 */
	public void preencherNovaIssue() {
		iview.exibirTelaCriacao();
		
		String titulo = iview.receberTitulo();
		String descricao = iview.receberDescricao();
		Criticidade criticidade = iview.receberCriticidade();
		Tipo tipo = iview.receberTipo();
		int dataCriacao = iview.receberDataCriacao();
		
		Issue issue = new Issue(titulo, descricao, criticidade, tipo, dataCriacao);
		
		addIssue(issue);
	}
	
	/**
	 * 
	 */
	public void exibirTodasIssuesPorCriticidade() {
		iview.exibirListaPorCriticidade();
		for (Issue issue : this.listaDeIssues) {
			exibirIssue(issue);
		}
	}
	
	/**
	 * 
	 */
	public void exibirTodasIssuesPorData() {
		iview.exibirListaPorData();
		Vetor<Issue> vetor = new Vetor<Issue>();
		int i = 0;
		for (Issue issue : this.listaDeIssues) {
			vetor.put(i, issue);
			i++;
		}
		
		vetor = ordenarPorData(vetor);
		
		for (int j = 0 ; j < vetor.getLength() ; i++) {
			exibirIssue(vetor.get(i));
		}
	}
	
	/**
	 * 
	 * @param vetor
	 * @param n
	 * @return
	 */
	public Vetor<Issue> ordenarPorData(Vetor<Issue> vetor) {
		Issue aux;
		int j;
		for (int i = 1; i < vetor.getLength(); i++) {
			
			j = i;
			while(j > 0 && vetor.get(j).getDataCriacao() < vetor.get(j - 1).getDataCriacao()) {
				aux = vetor.get(j);
				vetor.put(j, vetor.get(j - 1));
				vetor.put(j - 1, aux);
				
				j--;
			}
			
		}

		return vetor;
	}
	
	/**
	 * 
	 * @param issue
	 * @return
	 */
	public Issue getIssue(Issue issue) {
		try {
			return this.listaDeIssues.procura(issue).getValor();
		} 
		catch (ListaVaziaException e) {
			this.iview.exibir("A lista de Issues se encontra vazia.");
		} 
		catch (ItemNaoEncontradoException e) {
			this.iview.exibir("Infelizmente nao foi possivel encontrar a issue.");
		}
		return null;
	}
	
	/**
	 * 
	 * @param issue
	 */
	public void remove(Issue issue) {
		try {
			this.listaDeIssues.remover(issue);			
		} catch (ListaVaziaException e) {
			this.iview.exibir("A lista de Issues se encontra vazia.");			
			//e.printStackTrace();
		} catch (ItemNaoEncontradoException e) {
			this.iview.exibir("Infelizmente nao foi possivel encontrar a issue.");			
			//e.printStackTrace();
		}					
	}
}
