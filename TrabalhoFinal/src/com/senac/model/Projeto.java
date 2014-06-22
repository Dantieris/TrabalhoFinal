package com.senac.model;

import com.senac.model.Usuario;
import com.senac.lib.Vetor;
import com.senac.lib.ListaOrdenada;

public class Projeto implements Comparable<Projeto> {
	
	private Usuario criador;
	private Vetor<Usuario> desenvolvedor;
	private String nome;
	private String descricao;
 	private ListaOrdenada<Issue> issue;
	
 	/**
 	 * Novos objetos Projeto sempre ter�o:o Criador, nome do projeto, descri��o do projeto
 	 * e um vetor de desenvolvedores (iniciando em zero).
 	 * @param criador:Usuario (dono do projeto)
 	 * @param nome:String (nome do projeto)
 	 * @param descricao:String (descri��o do projeto)
 	 */
 	public Projeto(Usuario criador, String nome, String descricao){
 		this.setCriador(criador);
 		this.setNome(nome);
 		this.setDescricao(descricao);
 		this.desenvolvedor = new Vetor<>(0);
 	}
 	
 	/**
 	 * Adiciona um desenvolvedor a uma posi��o espec�ica do vetor. 
 	 * @param indice aonde o desenvolvedor ser� inserido (gerenciado pelo controller)
 	 * @param desenvolvedor a ser inserido no vetor
 	 */
 	//ignorar este m�todo, passar a utilizar pilha....ou n�o
 	public void addDesenvolvedor(int indice, Usuario desenvolvedor){
 		this.desenvolvedor.put(indice, desenvolvedor);
 	}
 	
 	/**
 	 * Busca um desenvolvedor em uma posi��o especifica do vetor.
 	 * @param indice
 	 * @return desenvolvedor(Usuario.class) a que o indice faz refer�ncia.
 	 */
 	public Usuario getDesenvolvedor(int indice){
 		return this.desenvolvedor.get(indice);
 	}
 	 	
 	/**
 	 * Compara��o por nome do projeto. Trabalha com ordem alfab�tica
 	 * -1 significa que este nome � anterior ao Projeto recebido via parametro (alfab�ticamente) 
 	 * +1 significa que o nome do projeto atual � posterior ao do projeto recebido como parametro.
 	 * 0 significa que ambos tem o mesmo nome. 
 	 * Passamos a responsabilidade de fazer a compara��o para a classe String.
 	 * 
 	 */
	public int compareTo(Projeto proj){		
		return this.nome.compareToIgnoreCase(proj.getNome());
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
	
	
	
	
	
}
