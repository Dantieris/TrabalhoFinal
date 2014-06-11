package com.senac.tests.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.lib.Criticidade;
import com.senac.model.Issue;
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
		projeto.addDesenvolvedor(0, desenvolvedor);
		assertEquals(projeto.getDesenvolvedor(0).getNome(),"Guilherme");
	}
	
	@Test
	public void testAddDoisDesenvolvedores(){
		Usuario desenvolvedor2 = mock(Usuario.class);
		when(desenvolvedor2.getNome()).thenReturn("Pedrinho");
		projeto.addDesenvolvedor(0,this.desenvolvedor);
		projeto.addDesenvolvedor(1,desenvolvedor2);		
		assertEquals(projeto.getDesenvolvedor(0).getNome(),"Guilherme");
		assertEquals(projeto.getDesenvolvedor(1).getNome(),"Pedrinho");		
	}

	
	@Test
	public void testCompareToProjetoAtualMaiorQueProjetoParametro() {
		Projeto maior = mock(Projeto.class);
		when(maior.getNome()).thenReturn("A");
		Projeto menor = mock(Projeto.class);
		when(menor.getNome()).thenReturn("B");
		int comparacao = maior.compareTo(menor);
		assertTrue( comparacao > 0 );
	}
	
	@Test
	public void testCompareToProjetoAtualMenorQueProjetoParametro() {
		Projeto maior = mock(Projeto.class);
		when(maior.getNome()).thenReturn("Abc");
		Projeto menor = mock(Projeto.class);
		when(menor.getNome()).thenReturn("Zdc");
		int comparacao = menor.compareTo(maior);
		assertEquals(1, comparacao);		
	}
}
