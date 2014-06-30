package com.senac.tests.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.controller.IssueController;
import com.senac.lib.Criticidade;
import com.senac.lib.Tipo;

public class EventoControllerTest {

	private IssueController ic;
	@Before
	public void setUp() throws Exception {
		ic = new IssueController();
	}

	@After
	public void tearDown() throws Exception {
		ic = null;
	}



}
