package com.senac.lib;

import java.util.Iterator;

import com.senac.lib.exceptions.ItemNaoEncontradoException;
import com.senac.lib.exceptions.ListaVaziaException;

/**
 *Esta classe representa a estrutura de dados lista duplamente encadeada ordenada, utilizando tipos genéricos.
 *
 * @param <T> O tipo da lista, deve implementar a interface Comparable com o próprio tipo.
 */
public class ListaOrdenada<T extends Comparable<T>> 
							implements Iterable<T>,
							Iterator<T>{

	private Nodo<T> head;
	private Nodo<T> tail;
	private Nodo<T> iter;
	
	/**
	 * Acessa o nodo head da lista.
	 * @return O head da lista.
	 */
	public Nodo<T> getHead() {
		return head;
	}

	/**
	 * Acessa o nodo tail da lista.
	 * @return O tail da lista.
	 */
	public Nodo<T> getTail() {
		return tail;
	}
	
	/**
	 * Adiciona um elemento à lista.
	 * @param valor O valor a ser inserido.
	 */
	public void inserir(T valor) {
		Nodo<T> novo = new Nodo<T>(valor);
		if ( isVazia() ) {
			this.head = novo;
			this.tail = novo;
			this.iter = head;
		}
		else {
			Nodo<T> nodo = procuraProximo(valor);
			
			if ( nodo != null ) {
				Nodo<T> nodoAnte = nodo.getAnterior();
				Nodo<T> nodoProx = nodo;
				
				novo.setProximo(nodoProx);
				novo.setAnterior(nodoAnte);
				
				if ( nodoAnte != null )
					nodoAnte.setProximo(novo);
				else
					this.head = novo;
				
				nodoProx.setAnterior(novo);	
			}
			else {
				Nodo<T> nodoAnte = tail;
				Nodo<T> nodoProx = null;
				
				novo.setProximo(nodoProx);
				novo.setAnterior(nodoAnte);

				tail.setProximo(novo);
				tail = novo;
			}
			
		}
	}
	
	/**
	 * Informa se a lista esta vazia.
	 * @return Verdadeiro se a lista estiver vazia, falso senão.
	 */
	private boolean isVazia() {
		if(head == null){
			return true;
		}else{
			return false;
		}		
	}
	
	/**
	 * Procura o proximo nodo ordenado da lista.
	 * @param valor O valor a se procurar o proximo na ordem.
	 * @return O nodo que será o proximo na ordem.
	 */
	private Nodo<T> procuraProximo(T valor) {
		Nodo<T> iter = this.head;
		while (iter != null) {
			int cmp = valor.compareTo(iter.getValor());
			
			if (cmp < 0)
				return iter;
			
			iter = iter.getProximo();
			}
			return null;
	}

	/**
	 * Procura um valor na lista, e retorna um nodo com o valor.
	 * 
	 * @param valor O valor a ser procurado.
	 * @return O nodo com o valor procurado.
	 * @throws ListaVaziaException Se a lista estiver vazia.
	 * @throws ItemNotFoundException Se o item não estiver na lista.
	 */
	public Nodo<T> procura(T valor) throws ListaVaziaException, ItemNaoEncontradoException {
		Nodo<T> iter = head;
		
		if (isVazia())
			throw new ListaVaziaException();
		
		while ( iter != null ) {
			int cmp = valor.compareTo(iter.getValor());
			
			if (cmp == 0)
				return iter;
			
			if (cmp < 0)
				throw new ItemNaoEncontradoException();

			iter = iter.getProximo();
		}
		throw new ItemNaoEncontradoException();
	}

	/**
	 * Retira um elemento da lista.
	 * 
	 * @param valor O valor a ser removido.
	 * @throws ListaVaziaException Se a lista estiver vazia.
	 * @throws ItemNotFoundException Se o item não estiver na lista.
	 */
	public void remover(T valor) throws ListaVaziaException, 
										ItemNaoEncontradoException 
	{
		Nodo<T> nodo = procura(valor);
		
		if ( nodo == this.head ) {
			this.head = nodo.getProximo();
			return;
		}
		
		if ( nodo == this.tail ) {
			this.tail = tail.getAnterior();
			tail.setProximo(null);
			return;
		}
		
		nodo.getAnterior().setProximo(nodo.getProximo());
		nodo.getProximo().setAnterior(nodo.getAnterior());
	}

	/**
	 * 
	 */
	@Override
	public Iterator<T> iterator() {
		return this;
	}
	
	public boolean hasNext () { 
		if (isVazia()){
			return false;
		}
		if (iter != null && iter.getProximo() != null){
			return true;		
		}
			return false;
	}
	
	static boolean first;
	public T next(){		
		if(iter.equals(head)){
			iter = iter.getProximo();
			first = true;
			return this.head.getValor();
		}

		if(hasNext()) {
			if(first){
				first = false;
				return iter.getValor();
				
			}
			iter = iter.getProximo();
			return iter.getValor();
		}
		return null;

	}	

	/**
	 * Método não implementado. Utilizar remover(T valor);
	 */
	@Override
	public void remove() {}
		
}
