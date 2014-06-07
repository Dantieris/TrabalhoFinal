package com.senac.lib;

/**
 * Representa um nodo de uma lista duplamente encadeada. 
 *
 * @param <T> O tipo do nodo.
 */
public class Nodo<T> {
	private Nodo<T> proximo;
	private Nodo<T> anterior;
	private T valor;
	
	/**
	 * Inicializa um objeto Nodo<T> recém-criado.
	 */
	public Nodo() {}

	/**
	 * Inicializa um objeto Nodo<T> recém-criado com o valor definido pelo parametro valor.
	 * 
	 * @param valor O valor do novo nodo.
	 */
	public Nodo(T valor) {
		this.valor = valor;
	}

	/**
	 * Acessa o próximo nodo da lista.
	 * @return O próximo nodo.
	 */
	public Nodo<T> getProximo() {
		return proximo;
	}

	/**
	 * Define o próximo nodo da lista.
	 * @param proximo O próximo nodo.
	 */
	public void setProximo(Nodo<T> proximo) {
		this.proximo = proximo;
	}

	/**
	 * Acessa o nodo anterior na lista.
	 * @return O nodo anterior.
	 */
	public Nodo<T> getAnterior() {
		return anterior;
	}

	/**
	 * Define o nodo anterior na lista.
	 * @param anterior O nodo anterior.
	 */
	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	/**
	 * Acessa o valor deste nodo.
	 * @return O valor do nodo.
	 */
	public T getValor() {
		return valor;
	}

	/**
	 * Define o valor do nodo.
	 * @param valor O valor a ser definido.
	 */
	public void setValor(T valor) {
		this.valor = valor;
	}
	
}
