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
	 * Inicializa um objeto UsuarioController recém-criado com a configuração padrão.
	 */
	public UsuarioController() {
		cadastrados = new Vetor<Usuario>();
		loggedIn = false;
		contadorCadastrados = 0;
		this.uView = new UsuarioView();
	}
	
	/**
	 * Realiza o login de um usuário no sistema. 
	 * O login é feito a partir da verificação 
	 * se o login e a senha batem com algum usuário cadastrado, 
	 * neste caso loggedIn é definido como verdadeiro 
	 * e usuarioLogado como o usuário que fecha com o login/senha.
	 * @param login Uma String com o login do usuário.
	 * @param senha Uma String com a senha do usuário.
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
	 * Acessa o valor do contador de usuários cadastrados no sistema.
	 * @return Um número inteiro com o valor do contadorCadastrados.
	 */
	public int getContadorCadastrados() {
		return contadorCadastrados;
	}

	/**
	 * Modifica o valor da variável loggedIn, 
	 * que informa para o sistema se ha um usuário logado, 
	 * ou não, no sistema.
	 * @param loggedIn Um boolean com o novo valor de loggedIn.
	 */
	public void setLoggedIn( boolean loggedIn ) {
		this.loggedIn = loggedIn;
	}
	
	/**
	 * Acessa o valor da variável loggedIn, 
	 * Verdadeiro se ha um usuário logado no sistema, Falso senão.
	 * @return Um boolean com o valor de loggedIn.
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Adiciona um usuário ao vetor de usuário cadastrados no sistema.
	 * @param usuario Um objeto Usuario com os valores do novo usuário.
	 */
	public void addUsuarioCadastrado(Usuario usuario) {
		cadastrados.put(contadorCadastrados++, usuario);
	}

	/**
	 * Acessa um espaço no vetor de usuários, e retorna este usuário.
	 * @param indice Um número inteiro que definira o indice do usuário.
	 * @return Um objeto Usuario com os valores do usuário.
	 */
	public Usuario getCadastrado(int indice) {
		return cadastrados.get(indice);
	}
	
	/**
	 * Acessao o usuário atual que está atualmente logado no sistema.
	 * @return Um objeto Usuario com o valor do usuário logado.
	 */
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	/**
	 * Modifica o usuário que está atualmente logado no sistema.
	 * @param usuarioLogado Um objeto Usuario com os valores do usuario a logar-se no sistema.
	 */
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	/**
	 * Cadastra um novo usuário no sistema. 
	 * Cria um usuário com os valores definidos pelos parâmetros nome, username, senha, 
	 * e adiciona este usuário ao vetor de usuários cadastrados.
	 * @param nome Uma Sting com o nome do novo usuário.
	 * @param username Uma Sting com o username do novo usuário.
	 * @param senha Uma Sting com a senha do novo usuário.
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
