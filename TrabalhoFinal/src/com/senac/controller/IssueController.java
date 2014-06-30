package com.senac.controller;

import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Tipo;
import com.senac.lib.Vetor;
import com.senac.model.Issue;
import com.senac.view.IssueView;

public class IssueController {

	private ListaOrdenada<Issue> listaDeIssues;
	private IssueView iview;
	
	
	public IssueController() {
		this.iview = new IssueView();
		this.listaDeIssues = new ListaOrdenada<Issue>();
	}
	
	public void exibirIssue(Issue issue) {
		iview.exibir(issue.toString());
	}
	
	public void addIssue(Issue issue) {
		this.listaDeIssues.inserir(issue);
	}
	
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
	
	public void exibirTodasIssuesPorCriticidade() {
		iview.exibirListaPorCriticidade();
		for (Issue issue : this.listaDeIssues) {
			exibirIssue(issue);
		}
	}
	
	public void exibirTodasIssuesPorData() {
		iview.exibirListaPorData();

		for (Issue issue : lista) {
			exibirIssue(issue);
		}
	}
	
	public Vetor<Issue> ordenarPorData() {
		Vetor<Issue> lista = new Vetor<Issue>();
		
		for (Issue issue : this.listaDeIssues) {
			
		}
		
		return lista;
	}
	
}
