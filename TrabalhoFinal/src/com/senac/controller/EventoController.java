package com.senac.controller;

import com.senac.lib.Vetor;
import com.senac.model.Evento;
import com.senac.view.EventoView;

public class EventoController {

	private Vetor<Evento> listaDeEventos;
	private EventoView eview;
	private int count;
	
	/**
	 * 
	 */
	public EventoController() {
		this.count = 0;
		this.eview = new EventoView();
		this.listaDeEventos = new Vetor<Evento>();
	}
	
	/**
	 * 
	 * @param issue
	 */
	public void exibirEvento(Evento evento) {
		eview.exibir(evento.toString());
	}
	
	/**
	 * 
	 * @param issue
	 */
	public void addEvento(Evento evento) {
		this.listaDeEventos.put(count, evento);
		count++;
	}

	
	
	/**
	 * 
	 */
	public void exibirTodosEventos() {
		eview.exibirListaEventos();
		for (int i = 0 ; i < listaDeEventos.getLength() ; i++) {
			exibirEvento(listaDeEventos.get(i));
		}
	}
	
	/**
	 * 
	 * @param issue
	 * @return
	 */
	public Evento getEvento(Evento evento) {
		for (int i = 0 ; i < listaDeEventos.getLength() ; i++) {
			if ( evento.equals(listaDeEventos.get(i)))
				return listaDeEventos.get(i);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param issue
	 */
	public void remove(Evento evento) {
		for (int i = 0 ; i < listaDeEventos.getLength() ; i++) {
			if ( evento.equals(listaDeEventos.get(i))) {
				listaDeEventos.put(i, null);
				break;
			}
				
		}	
	}
}
