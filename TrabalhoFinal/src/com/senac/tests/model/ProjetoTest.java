package com.senac.tests.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.senac.model.Projeto;
import com.senac.model.Usuario;
import static org.mockito.Mockito.*;
public class ProjetoTest {
	Projeto projeto;
	Usuario criador;
	@Before
	public void setUp() throws Exception {
		this.criador = mock(Usuario.class);
		projeto = new Projeto(criador, "Projeto Escola", "Projeto de uma escola totalmente online");
	}

	@After
	public void tearDown() throws Exception {
		projeto = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
