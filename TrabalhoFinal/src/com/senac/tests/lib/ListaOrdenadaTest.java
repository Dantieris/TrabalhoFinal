package com.senac.tests.lib;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.lib.ListaOrdenada;
import com.senac.lib.exceptions.ItemNaoEncontradoException;
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
		
		assertTrue( lista.getHead().getValor().equals(1) &&
					lista.getTail().getValor().equals(1) );
	}
	
	@Test
	public void testInserirDoisValoresOrdenadamente() {
		lista.inserir(1);
		lista.inserir(2);
		
		assertTrue( lista.getHead().getValor().equals(1) &&
					lista.getTail().getValor().equals(2) );
	}
	
	@Test
	public void testInserirTresValoresOrdenadamente() {
		lista.inserir(3);
		lista.inserir(1);
		lista.inserir(2);
		
		assertTrue( lista.getHead().getValor().equals(1) && 
					lista.getHead().getProximo().getValor().equals(2) &&
					lista.getTail().getValor().equals(3) );
	}

	@Test
	public void testProcurarQuandoListaPossuiItem() throws ListaVaziaException, 
	
														   ItemNaoEncontradoException
	{
		lista.inserir(3);
		lista.inserir(1);
		lista.inserir(2);
		
		assertEquals( (Integer) 2 , lista.procura(2).getValor() );
	}
	
	@Test(expected = ListaVaziaException.class)
	public void testProcuraLancaExcecaoQuandoListaVazia() throws ListaVaziaException, 
																 ItemNaoEncontradoException					
	{
		lista.procura(10);
	}
	
	@Test(expected = ItemNaoEncontradoException.class)
	public void testProcuraLancaExcecaoQuandoItemNaoEstaNaLista() throws ListaVaziaException, 
																		 ItemNaoEncontradoException 
	{
		lista.inserir(1);
		lista.procura(10);
	}
	
	@Test
	public void testRemoverItemDaListaQuandoListaTemUmItem() throws ListaVaziaException, 
											  						ItemNaoEncontradoException 
	{
		lista.inserir(1);
		lista.remover(1);
		
		assertTrue( lista.getHead() == null );
	}
	
	@Test(expected = ItemNaoEncontradoException.class)
	public void testRemoverTailComListaPopulada() throws ListaVaziaException,
																		  ItemNaoEncontradoException
	{
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.remover(3);
		lista.procura(3);
	}
	
	@Test(expected = ItemNaoEncontradoException.class)
	public void testRemoverItemComListaPopulada() throws ListaVaziaException,
														 ItemNaoEncontradoException
	{
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.remover(2);
		lista.procura(2);
	}
	
	@Test(expected = ItemNaoEncontradoException.class)
	public void testRemoverItensComListaPopulada() throws ListaVaziaException,
														 ItemNaoEncontradoException
	{
		for(int i = 0 ; i < 6 ; i++)
			lista.inserir(i);
		
		lista.remover(2);
		lista.remover(4);
		lista.procura(4);
	}
	
	@Test
	public void testHasNextRetornaFalseComListaVazia() {
		assertFalse(lista.hasNext());
	}
	
	@Test
	public void testHasNextRetornaFalseListaComUmItem() {
		lista.inserir(1);

		assertFalse( lista.hasNext() );
	}
	
	@Test
	public void testNextRetornaValorNodo() {
		lista.inserir(1);
		
		assertEquals( (Integer) 1, lista.next());
	}
	
	@Test
	public void testNextRetornaValorTerceiroItem() {
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.inserir(4);
		
		lista.getHead();
		lista.next();
		lista.next();
		
		assertEquals( (Integer) 3, lista.next());
	}
	
	//Apenas para debugar, nao e um teste real
	@Test
	public void testForEach(){
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.inserir(4);
		lista.inserir(5);
		lista.inserir(6);
		lista.inserir(7);
		lista.inserir(8);
		
		for(int i: lista){
			System.out.println(i);
		}
	}
	
}
