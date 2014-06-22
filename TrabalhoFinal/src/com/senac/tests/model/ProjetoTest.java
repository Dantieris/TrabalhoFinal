package com.senac.tests.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.senac.lib.Criticidade;
import com.senac.lib.Tipo;
import com.senac.lib.exceptions.ItemNaoEncontradoException;
import com.senac.lib.exceptions.ListaVaziaException;
import com.senac.model.Issue;
import com.senac.model.Projeto;
import com.senac.model.Usuario;
import static org.mockito.Mockito.*;
public class ProjetoTest {
	Projeto projeto;
	Usuario criador;
	Usuario desenvolvedor;
	Issue issue;
	@Before
	public void setUp() throws Exception {
		this.criador = mock(Usuario.class);
		this.desenvolvedor = mock(Usuario.class);
		when(this.desenvolvedor.getNome()).thenReturn("Guilherme");
		
		this.issue = new Issue("Titulo", "descricao", Criticidade.LOW, Tipo.BUG, 12345);		
		
		this.projeto = new Projeto(criador, "Projeto Escola", "Projeto de uma escola totalmente online");
	}

	@After
	public void tearDown() throws Exception {
		this.projeto = null;
		this.desenvolvedor = null;
		this.issue = null;
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
	public void testCompareToProjetoNomePosteriorAoProjetoParametro() {			
		Projeto nomeAnterior = new Projeto(this.criador, "A", "descricao");
		Projeto nomePosterior = new Projeto(this.criador, "B", "descricao");
		int comparacao = nomePosterior.compareTo(nomeAnterior);//tem que retornar um valor superior a zero				
		assertTrue( comparacao > 0 );
	}
	
	@Test
	public void testCompareToProjetoNomeAnteriorAoProjetoParametro() {
		Projeto nomeAnterior = new Projeto(this.criador, "A", "descricao");
		Projeto nomePosterior = new Projeto(this.criador, "B", "descricao");
		int comparacao = nomeAnterior.compareTo(nomePosterior);//tem que retonrnar um valor menor que zero				
		assertTrue(comparacao < 0);		
	}
	
	@Test
	public void testCompareToDuasStringsIguais(){
		int comparacao = this.projeto.compareTo(this.projeto);//tem que retornar zero
		assertTrue(comparacao == 0);
	}
	
	@Test
	public void testAddIssueEGetIssue(){
		
		this.projeto.addIssue(this.issue);						
		
				try {
					assertEquals(issue, this.projeto.getIssue(issue));
				} catch (ListaVaziaException e) {
					// TODO Auto-generated catch block
					fail("lista vazia");
					e.printStackTrace();
				} catch (ItemNaoEncontradoException e) {
					// TODO Auto-generated catch block
					fail("item nao encontrado");
					e.printStackTrace();
				}
			
		
		
	}
}
