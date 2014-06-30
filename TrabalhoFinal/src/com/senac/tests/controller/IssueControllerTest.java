package com.senac.tests.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.controller.IssueController;
import com.senac.lib.Criticidade;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.Tipo;
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
		ic.addIssue(new Issue("", "", Criticidade.CRITICAL, Tipo.BUG, 1));
		ic.addIssue(new Issue("", "", Criticidade.CRITICAL, Tipo.BUG, 4));
		ic.addIssue(new Issue("", "", Criticidade.CRITICAL, Tipo.BUG, 2));
		
		ListaOrdenada<Issue> lista = ic.ordenarPorData();
		
		assertTrue( lista.next().equals(1) &&
					lista.next().equals(2) && 
					lista.next().equals(4) );
	}

}
