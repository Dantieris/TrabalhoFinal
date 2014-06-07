package com.senac.tests.lib;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.lib.ListaOrdenada;
import com.senac.lib.exceptions.ItemNotFoundException;
import com.senac.lib.exceptions.ListaVaziaException;

public class ListaOrdenadaTest {

	private ListaOrdenada<Integer> lista;
	@Before
	public void setUp() throws Exception {
		lista = new ListaOrdenada<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	@Test
	public void testInserirComListaVaziaColocaNodoNaHeadETail() {
		lista.inserir(1);
		
		assertTrue( (Integer) 1 == lista.getHead().getValor() &&
					(Integer) 1 == lista.getTail().getValor() );
	}
	
	@Test
	public void testInserirDoisValoresOrdenadamente() {
		lista.inserir(1);
		lista.inserir(2);
		
		assertTrue( (Integer) 1 == lista.getHead().getValor() &&
					(Integer) 2 == lista.getTail().getValor() );
	}
	
	@Test
	public void testInserirTresValoresOrdenadamente() {
		lista.inserir(3);
		lista.inserir(1);
		lista.inserir(2);
		
		assertTrue( (Integer) 1 == lista.getHead().getValor() && 
					(Integer) 2 == lista.getHead().getProximo().getValor() &&
					(Integer) 3 == lista.getTail().getValor() );
	}

	@Test
	public void testProcurarQuandoListaPossuiItem() throws ListaVaziaException, 
	
														   ItemNotFoundException
	{
		lista.inserir(3);
		lista.inserir(1);
		lista.inserir(2);
		
		assertEquals( (Integer) 2 , lista.procura(2).getValor() );
	}
	
	@Test(expected = ListaVaziaException.class)
	public void testProcuraLancaExcecaoQuandoListaVazia() throws ListaVaziaException, 
																 ItemNotFoundException					
	{
		lista.procura(10);
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testProcuraLancaExcecaoQuandoItemNaoEstaNaLista() throws ListaVaziaException, 
																		 ItemNotFoundException 
	{
		lista.inserir(1);
		lista.procura(10);
	}
	
	@Test
	public void testRemoverItemDaListaQuandoListaTemUmItem() throws ListaVaziaException, 
											  						ItemNotFoundException 
	{
		lista.inserir(1);
		lista.remover(1);
		
		assertTrue( lista.getHead() == null );
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoverTailComListaPopulada() throws ListaVaziaException,
																		  ItemNotFoundException
	{
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.remover(3);
		lista.procura(3);
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoverItemComListaPopulada() throws ListaVaziaException,
														 ItemNotFoundException
	{
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.remover(2);
		lista.procura(2);
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoverItensComListaPopulada() throws ListaVaziaException,
														 ItemNotFoundException
	{
		for(int i = 0 ; i < 6 ; i++)
			lista.inserir(i);
		
		lista.remover(2);
		lista.remover(4);
		lista.procura(4);
	}
	
}
