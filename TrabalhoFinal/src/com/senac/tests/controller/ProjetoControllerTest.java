package com.senac.tests.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.senac.controller.ProjetoController;
import com.senac.model.*;
import static org.mockito.Mockito.*;
public class ProjetoControllerTest {

	
	private ProjetoController projController;
	private Projeto projeto;
	private Projeto proj;
	private Usuario desenvolvedor;
	
	@Before
	public void setUp() throws Exception {
		this.projController = new ProjetoController();
		this.projeto = mock(Projeto.class);
		this.desenvolvedor = mock(Usuario.class);
		this.proj = new Projeto(this.desenvolvedor, "Proj", "projeto teste");
		
		when(this.desenvolvedor.getNome()).thenReturn("Guilherme");
		
	}

	@After
	public void tearDown() throws Exception {		
		this.projController = null;
		this.proj = null;
		desenvolvedor = null;
		projeto = null;		
	}

	@Test
	public void testAdicionarProjetoAListaERetornarProjeto() {		
		this.projController.addProjeto(proj);
		
		assertEquals(proj, this.projController.getProjeto(proj));
	}
	
	@Test
	public void testAdicionarTresProjetosAListaERetornarSegundoProjeto() {		
		Projeto proj2 = new Projeto(this.desenvolvedor, "Proj2", "projeto teste2");
		Projeto proj3 = new Projeto(this.desenvolvedor, "Proj3", "projeto teste3");
		this.projController.addProjeto(proj);
		this.projController.addProjeto(proj2);
		this.projController.addProjeto(proj3);
		
		assertEquals(proj2, this.projController.getProjeto(proj2));
	}
	

	@Test
	public void testRemoverProjetoDaListaVazia(){		
		this.projController.addProjeto(proj);
		this.projController.remove(proj);
		assertEquals(null, this.projController.getProjeto(proj));
	}
	
	
	@Test
	public void testRemoverProjetoDaListaPreenchida(){		
		Projeto proj2 = new Projeto(this.desenvolvedor, "Proj2", "projeto teste2");
		Projeto proj3 = new Projeto(this.desenvolvedor, "Proj3", "projeto teste3");
		this.projController.addProjeto(proj2);
		this.projController.addProjeto(proj);
		this.projController.addProjeto(proj3);
		this.projController.remove(proj);
		assertEquals(null, this.projController.getProjeto(proj));
	}
	
	@Test
	public void testForEachListarUmProjeto(){
		this.projController.addProjeto(this.proj);
		for(Projeto projeto : this.projController.getListaDeProjetos()){
			assertEquals(proj, projeto);
			System.out.println(projeto.getNome());
		}
	}
	
	
	@Test
	public void testForEachListarProjetos(){
		Projeto proj2 = new Projeto(this.desenvolvedor, "Proj2", "projeto teste2");
		Projeto proj3 = new Projeto(this.desenvolvedor, "Proj3", "projeto teste3");
		this.projController.addProjeto(proj);
		this.projController.addProjeto(proj2);
		this.projController.addProjeto(proj3);
		
		for(Projeto proj : this.projController.getListaDeProjetos()){
			System.out.println(proj.getNome() +" - "+ proj.getId());
		}
	}
}
