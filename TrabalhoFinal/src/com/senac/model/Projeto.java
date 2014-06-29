package com.senac.model;

import com.senac.model.Usuario;
import com.senac.lib.Vetor;
import com.senac.lib.ListaOrdenada;
import com.senac.lib.exceptions.ItemNaoEncontradoException;
import com.senac.lib.exceptions.ListaVaziaException;

public class Projeto implements Comparable<Projeto>{
	private static int ID_COUNT = 1; 
	private int id;
	private Usuario criador;
	private Vetor<Usuario> desenvolvedor;
	private String nome;
	private String descricao;
 	private ListaOrdenada<Issue> issue;
	
 	/**
 	 * Novos objetos Projeto sempre terao:o Criador, nome do projeto, descrição do projeto
 	 * e um vetor de desenvolvedores (iniciando em zero).
 	 * @param criador:Usuario (dono do projeto)
 	 * @param nome:String (nome do projeto)
 	 * @param descricao:String (descrição do projeto)
 	 */
 	public Projeto(Usuario criador, String nome, String descricao){
 		ID_COUNT ++;
 		this.id = ID_COUNT;
 		this.setCriador(criador);
 		this.setNome(nome);
 		this.setDescricao(descricao);
 		this.desenvolvedor = new Vetor<>(0);
 		this.issue = new ListaOrdenada<Issue>();
 	}
 	
 	/**
 	 * Adiciona um desenvolvedor a uma posicao especiica do vetor. 
 	 * @param indice aonde o desenvolvedor sera inserido (gerenciado pelo controller)
 	 * @param desenvolvedor a ser inserido no vetor
 	 */
 	//ignorar este método, passar a utilizar pilha....ou não
 	public void addDesenvolvedor(int indice, Usuario desenvolvedor){
 		this.desenvolvedor.put(indice, desenvolvedor);
 	}
 	
 	/**
 	 * Busca um desenvolvedor em uma posicao especifica do vetor.
 	 * @param indice
 	 * @return desenvolvedor(Usuario.class) a que o indice faz referencia.
 	 */
 	public Usuario getDesenvolvedor(int indice){
 		return this.desenvolvedor.get(indice);
 	}
 	
 	 	
 	/**
 	 * Retorna o tamanho da lista de desenvolvedores.
 	 * @return
 	 */
 	public int getListaDesenvolvedorLength(){
 		return this.desenvolvedor.getLength();
 	}
 	
 	
 	/**
 	 * Comparação por nome do projeto. Trabalha com ordem alfabetica
 	 * -1 significa que este nome eh anterior ao Projeto recebido via parametro (alfabeticamente) 
 	 * +1 significa que o nome do projeto atual eh posterior ao do projeto recebido como parametro.
 	 * 0 significa que ambos tem o mesmo nome. 
 	 * Passamos a responsabilidade de fazer a comparaçao para a classe String.
 	 * 
 	 */
	public int compareTo(Projeto proj){		
		return this.getNome().compareToIgnoreCase(proj.getNome());
	}

	/**
	 * Insere uma issue na listaOrdenada de Issues
	 * @param issue
	 */
	public void addIssue(Issue issue){
		this.issue.inserir(issue);
	}
	
	/**
	 * Procura uma Issue na listaOrdenada de Issues, Lança excessões caso a lista esteja vazia, 
	 * ou a issue buscada nao seja encontrada.
	 * @param issue
	 * @throws ListaVaziaException
	 * @throws ItemNaoEncontradoException
	 */
	public Issue getIssue(Issue issue) throws ListaVaziaException, ItemNaoEncontradoException{
		return this.issue.procura(issue).getValor();
	}
	
	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId(){
		return this.id;
	}
	
	
	
	
}
