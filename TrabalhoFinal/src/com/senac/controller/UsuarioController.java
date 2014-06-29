package com.senac.controller;

import com.senac.lib.Vetor;
import com.senac.model.Usuario;
import com.senac.view.UsuarioView;


public class UsuarioController {

	private Usuario usuarioLogado;
	private Vetor<Usuario> cadastrados;
	private int contadorCadastrados;
	private boolean loggedIn;
	private UsuarioView uView;
	
	/**
	 * Inicializa um objeto UsuarioController rec�m-criado com a configura��o padr�o.
	 */
	public UsuarioController() {
		cadastrados = new Vetor<Usuario>();
		loggedIn = false;
		contadorCadastrados = 0;
		this.uView = new UsuarioView();
	}
	
	/**
	 * Realiza o login de um usu�rio no sistema. 
	 * O login � feito a partir da verifica��o 
	 * se o login e a senha batem com algum usu�rio cadastrado, 
	 * neste caso loggedIn � definido como verdadeiro 
	 * e usuarioLogado como o usu�rio que fecha com o login/senha.
	 * @param login Uma String com o login do usu�rio.
	 * @param senha Uma String com a senha do usu�rio.
	 */
	public void login(String login, String senha) {
		for(int i = 0 ; i < cadastrados.getLength() ; i++) {
			if (cadastrados.get(i).getUsername() == login && cadastrados.get(i).getSenha() == senha ) {
				setLoggedIn(true);
				setUsuarioLogado(cadastrados.get(i));
			}
		}
		
	}
	
	/**
	 * Acessa o valor do contador de usu�rios cadastrados no sistema.
	 * @return Um n�mero inteiro com o valor do contadorCadastrados.
	 */
	public int getContadorCadastrados() {
		return contadorCadastrados;
	}

	/**
	 * Modifica o valor da vari�vel loggedIn, 
	 * que informa para o sistema se ha um usu�rio logado, 
	 * ou n�o, no sistema.
	 * @param loggedIn Um boolean com o novo valor de loggedIn.
	 */
	public void setLoggedIn( boolean loggedIn ) {
		this.loggedIn = loggedIn;
	}
	
	/**
	 * Acessa o valor da vari�vel loggedIn, 
	 * Verdadeiro se ha um usu�rio logado no sistema, Falso sen�o.
	 * @return Um boolean com o valor de loggedIn.
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Adiciona um usu�rio ao vetor de usu�rio cadastrados no sistema.
	 * @param usuario Um objeto Usuario com os valores do novo usu�rio.
	 */
	public void addUsuarioCadastrado(Usuario usuario) {
		cadastrados.put(contadorCadastrados++, usuario);
	}

	/**
	 * Acessa um espa�o no vetor de usu�rios, e retorna este usu�rio.
	 * @param indice Um n�mero inteiro que definira o indice do usu�rio.
	 * @return Um objeto Usuario com os valores do usu�rio.
	 */
	public Usuario getCadastrado(int indice) {
		return cadastrados.get(indice);
	}
	
	/**
	 * Acessao o usu�rio atual que est� atualmente logado no sistema.
	 * @return Um objeto Usuario com o valor do usu�rio logado.
	 */
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	/**
	 * Modifica o usu�rio que est� atualmente logado no sistema.
	 * @param usuarioLogado Um objeto Usuario com os valores do usuario a logar-se no sistema.
	 */
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	/**
	 * Cadastra um novo usu�rio no sistema. 
	 * Cria um usu�rio com os valores definidos pelos par�metros nome, username, senha, 
	 * e adiciona este usu�rio ao vetor de usu�rios cadastrados.
	 * @param nome Uma Sting com o nome do novo usu�rio.
	 * @param username Uma Sting com o username do novo usu�rio.
	 * @param senha Uma Sting com a senha do novo usu�rio.
	 */
	public void cadastrar(String nome, String username, String senha) {
		addUsuarioCadastrado( new Usuario(nome, username, senha) );
	}
	
	/**
	 * Exibe o nome do usuario
	 * @param usuario
	 */
	public void exibirNomeusuario(Usuario usuario){
		this.uView.exibirNome(usuario.getNome());
	}
	
}
