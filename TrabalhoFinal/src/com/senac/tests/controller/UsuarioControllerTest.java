package com.senac.tests.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.controller.UsuarioController;
import com.senac.model.Usuario;

public class UsuarioControllerTest {

	private UsuarioController uc;
	@Before
	public void setUp() throws Exception {
		uc = new UsuarioController();
	}

	@After
	public void tearDown() throws Exception {
		uc = null;
	}

	@Test(expected = NullPointerException.class)
	public void testLoginSemUsuarioCadastradoLancaExcecao() throws NullPointerException {
		uc.login("", "");
	}
	
	@Test
	public void testCadastrarUsuario() {
		Usuario usuario = new Usuario("nome", "username", "senha");
		uc.addUsuarioCadastrado(usuario);
		
		assertTrue(uc.getCadastrado(0) == usuario);
	}
	
	@Test
	public void testCadastrarTresUsuarios() {
		Usuario usuario1 = new Usuario("nome", "username", "senha");
		Usuario usuario2 = new Usuario("nome", "username", "senha");
		Usuario usuario3 = new Usuario("nome", "username", "senha");
		
		uc.addUsuarioCadastrado(usuario1);
		uc.addUsuarioCadastrado(usuario2);
		uc.addUsuarioCadastrado(usuario3);
		
		assertTrue( uc.getCadastrado(0) == usuario1 &&
					uc.getCadastrado(1) == usuario2 &&
					uc.getCadastrado(2) == usuario3 );
	}
	
	@Test
	public void testLoginUsuarioCadastradoLoginErradoFalhar() {
		Usuario usuario = new Usuario("nome", "login", "senha");
		uc.addUsuarioCadastrado(usuario);
		uc.login("errado", "senha");
		
		assertFalse( uc.isLoggedIn() &&
					uc.getUsuarioLogado() == usuario );
	}

	@Test
	public void testLoginUsuarioCadastradoSenhaErradaFalhar() {
		Usuario usuario = new Usuario("nome", "login", "senha");
		uc.addUsuarioCadastrado(usuario);
		uc.login("login", "errada");
		
		assertFalse( uc.isLoggedIn() &&
					uc.getUsuarioLogado() == usuario );
	}
	
	@Test
	public void testLoginUsuarioCadastradoLoginSenhaCorretosSucesso() {
		Usuario usuario = new Usuario("nome", "login", "senha");
		uc.addUsuarioCadastrado(usuario);
		uc.login("login", "senha");
		
		assertTrue( uc.isLoggedIn() &&
					uc.getUsuarioLogado() == usuario );
	}
	
	@Test
	public void testCadastrarCincoUsuariosLogarComTerceiroSucesso() {
		Usuario usuario1 = new Usuario("nome1", "username1", "senha");
		Usuario usuario2 = new Usuario("nome2", "username2", "senha");
		Usuario usuario3 = new Usuario("nome3", "username3", "senha");
		Usuario usuario4 = new Usuario("nome4", "username4", "senha");
		Usuario usuario5 = new Usuario("nome5", "username5", "senha");
		
		uc.addUsuarioCadastrado(usuario1);
		uc.addUsuarioCadastrado(usuario2);
		uc.addUsuarioCadastrado(usuario3);
		uc.addUsuarioCadastrado(usuario4);
		uc.addUsuarioCadastrado(usuario5);
		
		uc.login("username3", "senha");
		
		assertTrue( uc.isLoggedIn() &&
					uc.getUsuarioLogado() == usuario3 );
	}
	
	@Test
	public void testCadastrarUsuarioComNomeUsernameSenhaValidos() {
		uc.cadastrar("nomeValido", "usernameValido", "senhaValida");
		
		assertTrue( uc.getCadastrado(0).getNome() == "nomeValido" &&
					uc.getCadastrado(0).getUsername() == "usernameValido" &&
					uc.getCadastrado(0).getSenha() == "senhaValida");
	}
	
}
