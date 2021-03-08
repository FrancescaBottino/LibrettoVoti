package it.polito.tdp.librettovotiModel;

import java.time.LocalDate;

//POJO: Plain Old Java Object
//Java Bean
//semplice contenitore di dati, no logica, non fa cose

/**
 * memorizza voto di un esame
 * 
 * @author frensis
 *
 */
public class Voto {
	
	private String nomeCorso;
	private int voto; //30L?
	private LocalDate data;
	
	
	public Voto(String nomeCorso, int voto, LocalDate data) {
		super();
		this.nomeCorso = nomeCorso;
		this.voto = voto;
		this.data = data;
	}


	public String getNomeCorso() {
		return nomeCorso;
	}


	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Esame "+ nomeCorso + " superato con " + voto + " il " + data;
	}
	
	
	
	

}
