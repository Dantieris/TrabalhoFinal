package com.senac.tests.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.controller.IssueController;
import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Tipo;
import com.senac.lib.Vetor;
import com.senac.model.Issue;

public class IssueControllerTest {

	private IssueController ic;
	@Before
	public void setUp() throws Exception {
		ic = new IssueController();
	}

	@After
	public void tearDown() throws Exception {
		ic = null;
	}

	@Test
	public void testOrdenarPorDataRetornaListaOrdenada() {
		Vetor<Issue> vetor = new Vetor<Issue>();
		
		vetor.put(0, new Issue("", "", Criticidade.CRITICAL, Tipo.BUG, 3));
		vetor.put(1, new Issue("", "", Criticidade.CRITICAL, Tipo.BUG, 1));
		vetor.put(2, new Issue("", "", Criticidade.CRITICAL, Tipo.BUG, 2));
		
		vetor = ic.ordenarPorData(vetor);
		
		assertTrue( vetor.get(0).getDataCriacao() == 1 &&
					vetor.get(1).getDataCriacao() == 2 && 
					vetor.get(2).getDataCriacao() == 3  );
	}

}
