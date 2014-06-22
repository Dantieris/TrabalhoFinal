package com.senac.lib;
/**
* Esta classe representa uma estrutura de dados Vetor, 
* inserindo ou retirando valores determinados pelo indice.
*/
public class Vetor<T> {

	protected Object[] dados;
	
	/**
	* Inicializa um objeto Vetor<T> recém-criado com o tamanho definido pelo parametro.
	*
	* @param tamanho O tamanho do vetor.
	*/
	public Vetor(int tamanho) {
		dados = new Object[tamanho];
	}
	
	/**
	* Inicializa um objeto Vetor<T> recém-criado com um espaço disponível.
	*/
	public Vetor() {
		dados = new Object[1];
	}
	
	/**
	* Acessa o tamanho do vetor.
	*
	* @return Um inteiro contetndo o tamanho do vetor.
	*/
	public int getLength() {
		return dados.length;
	}

	/**
	* Acessa um item do vetor.
	*
	* @param indice Posição do item.
	* @return O objeto inserido na posição.
	*/
	@SuppressWarnings("unchecked")
	public T get(int indice) throws IndexOutOfBoundsException {
		if ( indice >= getLength() )
			throw new IndexOutOfBoundsException();
		
		return (T) dados[indice];
	}

	/**
	* Modifica um elemento do vetor.
	*
	* @param indice Posição do elemento no vetor.
	* @param valor Valor a ser modificado.
	*/
	public void put(int indice, T valor) {		
		if ( indice >= getLength() ) {
			aumentaVetor(indice + 1);
		}
		dados[indice] = valor;
	}

	/**
	* Acessa o vetor de dados.
	* @return O vetor de dados.
	*/
	@SuppressWarnings("unchecked")
	public T[] getDados() {
		return (T[]) dados;
	}
	
		
	/**
	 * Aumenta o tamanho do vetor.
	 * 
	 * @param tamanho O novo tamanho do vetor.
	 */
	private void aumentaVetor( int tamanho ) {
		Object[] temp = new Object[tamanho];
		
		System.arraycopy(this.dados, 0, temp, 0, this.dados.length);
		this.dados = temp;
	}
	
	
}
