package com.senac.tests.lib;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.lib.Vetor;

public class VetorTest {

	private Vetor<Integer> vetor;
	@Before
	public void setUp() throws Exception {
		vetor = new Vetor<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		vetor = null;
	}

	@Test
	public void testCriarVetorDefinindoTamanhoNaCriacao() {
		Vetor<Integer> vetor = new Vetor<Integer>(2);
		
		assertEquals(2, vetor.getLength());
	}

	@Test
	public void testPutEGet() {
		vetor.put(0,1);
		
		assertEquals( (Integer) 1, vetor.get(0));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetLancaExcecaoIndiceMaiorOuIgualALength() throws IndexOutOfBoundsException {
		vetor.get(1);
	}
	
	@Test
	public void testInserirValorComIndiceMaiorQueLengthAumentarVetor() {
		vetor.put(3, 2);
		
		assertTrue(4 == vetor.getLength() &&
				   vetor.get(3) == 2 );
	}
	
}
