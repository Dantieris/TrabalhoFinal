package com.senac.controller;

import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Tipo;
import com.senac.lib.Vetor;
import com.senac.model.Issue;
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
	
}
