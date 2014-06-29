package com.senac.view;

import java.util.Scanner;

public class UsuarioView {

	private static final Scanner entrada = new Scanner(System.in);
	
	public static void printTelaLogin() {
		System.out.println("### Tela de Login ###\n");
	}
	
	/**
	 * Imprime na tela a mensagem de login, e recebe o login do usuário.
	 * @return Uma String com o login do usuário.
	 */
	public static String printUsername() {
		System.out.print("Username: ");
		return entrada.next();
	}
	
	/**
	 * Imprime na tela a mensagem de senha, e recebe a senha do usuário.
	 * @return Uma String com a senha do usuário.
	 */
	public static String printSenha() {
		System.out.print("Senha: ");
		return entrada.next();
	}
	
	public static void printTelaCadastro() {
		System.out.println("### Tela de Cadastro ###\n");
	}
	
	/**
	 * Imprime na tela a mensagem de nome, e recebe o nome do usuário.
	 * @return Uma String com o nome do usuário.
	 */
	public static String printName() {
		System.out.println("Nome: ");
		return entrada.nextLine();
	}
	
	/**
	 * Imprime na tela a mensagem de confirme a senha, 
	 * e recebe novamente a senha do usuário, que deve ser igual a senha que ja foi digitada.
	 * @return Uma String com a senha do usuário.
	 */
	public static String printConfirmarSenha() {
		System.out.println("Confirme a Senha: ");
		return entrada.next();
	}
	
	
	public void exibirNome(String nome){
		System.out.println("Nome: " + nome);
	}
	
}
