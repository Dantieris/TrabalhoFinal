package com.senac.view;

import java.util.Scanner;

public class ConsoleView {

	protected static Scanner ler = new Scanner(System.in);
	
	
	public void exibir(String mensagem){
		System.out.println(mensagem);
	}
	
	public String receber(){
		return ler.nextLine();
	}
	
	public String receber(String mensagem){
		this.exibir(mensagem);
		return ler.nextLine();
	}
	
}
