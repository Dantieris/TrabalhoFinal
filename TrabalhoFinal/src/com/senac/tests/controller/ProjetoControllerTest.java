package com.senac.tests.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.senac.controller.ProjetoController;
import com.senac.model.*;
import static org.mockito.Mockito.*;
public class ProjetoControllerTest {

	
	private ProjetoController projController;
	private Projeto projeto;
	
	
	@Before
	public void setUp() throws Exception {
		this.projController = new ProjetoController();
		this.projeto = mock(Projeto.class);
	}

	@After
	public void tearDown() throws Exception {
		this.projController = null;
	}

	@Test
	public void testCriarProjeto() {
		this.projController.addProjeto(this.projeto);
	}

}
