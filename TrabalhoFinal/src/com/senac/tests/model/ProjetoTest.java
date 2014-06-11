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
	Usuario desenvolvedor;
	@Before
	public void setUp() throws Exception {
		this.criador = mock(Usuario.class);
		this.desenvolvedor = mock(Usuario.class);
		when(this.desenvolvedor.getNome()).thenReturn("Guilherme");
		this.projeto = new Projeto(criador, "Projeto Escola", "Projeto de uma escola totalmente online");
	}

	@After
	public void tearDown() throws Exception {
		projeto = null;
	}

	 /**
	  * Por se tratar de um 'set' acabamos tendo que testar juntamente
	  * o 'get', o que embora seja 'feio' não quebra as regras do TDD (
	  * nestes casos específicos).
	  */
	@Test
	public void testAddDesenvolvedor() {			
		projeto.addDesenvolvedor(desenvolvedor);
		assertEquals(projeto.getDesenvolvedor(0).getNome(),"Guilherme");
	}
	
	@Test
	public void testAddDoisDesenvolvedores(){
		Usuario desenvolvedor2 = mock(Usuario.class);
		when(desenvolvedor2.getNome()).thenReturn("Pedrinho");
		projeto.addDesenvolvedor(this.desenvolvedor);
		projeto.addDesenvolvedor(desenvolvedor2);		
		assertEquals(projeto.getDesenvolvedor().getNome(),"Guilherme");
		assertEquals(projeto.getDesenvolvedor().getNome(),"Pedrinho");
		
	}

}
