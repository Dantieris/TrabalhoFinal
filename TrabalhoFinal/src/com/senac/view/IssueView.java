package com.senac.view;

import com.senac.lib.Criticidade;
import com.senac.lib.Tipo;

public class IssueView extends ConsoleView {
	
	public void exibirTelaCriacao() {
		this.exibir( "### Tela de Criação ###" );
	}
	
	public void exibirTelaAlteracao() {
		this.exibir( "### Tela de Criação ###" );
	}
	
	public String receberTitulo() {
		return this.receber("Titulo: ");
	}
	
	public String receberDescricao() {
		return this.receber("Descrição: ");
	}

	public Criticidade receberCriticidade() {
		
		String crit = this.receber("Definindo Criticidade"
							+ "\n1 - Low"
							+ "\n2 - Medium"
							+ "\n3 - High"
							+ "\n4 - Critical"
							+ "\n5 - Blocker");
		
		switch (crit) {
		case "1" : return Criticidade.LOW;
		case "2" : return Criticidade.MEDIUM;
		case "3" : return Criticidade.HIGH;
		case "4" : return Criticidade.CRITICAL;
		case "5" : return Criticidade.BLOCKER;
		default  : return Criticidade.LOW;
		}
	}
	
	public Tipo receberTipo() {
		String tipo = this.receber("Definindo Tipo"
							+ "\n1 - Bug"
							+ "\n2 - Enhancement");
		
		switch (tipo) {
		case "1" : return Tipo.BUG;
		case "2" : return Tipo.ENHANCEMENT;
		default  : return Tipo.BUG;
		}
	}
	
	public int receberDataCriacao() {
		System.out.println("Data de Criação: ");
		return this.ler.nextInt();
	}
	
	public void exibirListaPorCriticidade() {
		this.exibir("### Lista de Issues : Ordenadas por Criticidade ###");
	}

	public void exibirListaPorData() {
		this.exibir("### Lista de Issues : Ordenadas por Data de Criação ###");
	}
}
