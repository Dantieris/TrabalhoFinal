package com.senac.tests.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.lib.Criticidade;
import com.senac.lib.Tipo;
import com.senac.model.Evento;
import com.senac.model.Issue;

public class IssueTest {

	private Issue issue;
	@Before
	public void setUp() throws Exception {
		issue = new Issue("", "", Criticidade.MEDIUM, null, 0);
	}

	@After
	public void tearDown() throws Exception {
		issue = null;
	}

	@Test
	public void testCompareToPorCriticidadeMaiorQueIssueAtual() {
		Issue medium = new Issue("", "", Criticidade.HIGH, null, 0);
		int comparacao = issue.compareTo(medium);
		
		assertTrue( comparacao < 0 );
	}
	
	@Test
	public void testCompareToPorCriticidadeMenorQueIssueAtual() {
		Issue low = new Issue("", "", Criticidade.LOW, null, 0);
		int comparacao = issue.compareTo(low);
		
		assertTrue( comparacao > 0 );
	}
	
	@Test
	public void testCompareToPorCriticidadeIgualAIssueAtual() {
		Issue medium = new Issue("", "", Criticidade.MEDIUM, null, 0);
		int comparacao = issue.compareTo(medium);
		
		assertTrue( comparacao == 0 );
	}
	
	@Test
	public void testAdicionarEventoGetEventoRetornaEvento () {
		Evento evento = new Evento(12, "", null);
		issue.add( evento );
		
		assertTrue( evento == issue.getEvento(0) );
	}
	
	@Test
	public void testAdicionandoDoisEventos() {
		Evento evento1 = new Evento(1,"",null);
		Evento evento2 = new Evento(2,"",null);
		
		issue.add( evento1 );
		issue.add( evento2 );
		
		assertTrue( evento1 == issue.getEvento(0) &&
					evento2 == issue.getEvento(1) );
	}
	
	@Test
	public void testToStringRetornaFormatoCorreto() {
		Issue issue = new Issue("Titulo", "Descricao" , Criticidade.CRITICAL, Tipo.BUG, 1052014);
		assertEquals("Titulo Descricao - NOVO - CRITICAL - BUG - 1052014", issue.toString());
	}

}
