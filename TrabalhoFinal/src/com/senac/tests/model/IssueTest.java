package com.senac.tests.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.lib.Criticidade;
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

}
