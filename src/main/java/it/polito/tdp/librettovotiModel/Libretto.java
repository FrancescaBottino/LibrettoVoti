package it.polito.tdp.librettovotiModel;

import java.util.ArrayList;
import java.util.List;


public class Libretto {
	
	//contiene al suo interno dei voti
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();
		
		
	}
	public void add(Voto v) {
		this.voti.add(v);
		
	}
	
	/*public void stampaVotiUguali(int punteggio) {
		//il libretto stampa solo i voti, non ha i riferimenti agli 
		//oggetti, non posso fare altre operazioni
	}
	
	//Meglio questa seconda
	
	public String votiUguali(int punteggio) {
		///calcola una strnga che contiene i voti e 
		//sarà poi il chiamante a stamparli
		//cosa stampo?
		
	}
	*/
	//ma ancora meglio.. 
	
	public List<Voto> listaVotiUguali(int punteggio){
		
		//restituisce una lista di voti uguali al criterio
		//do anche altre informazioni poi chi li vuole li usa/stampa
		//Difetto : espone all'esterno il tipo di struttura dati che ho usato
		
		List<Voto> risultato= new ArrayList<>();
		
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);  //v è contemporaneamente contenuto in 2
			                       //liste diverse: v è lo stesso oggetto 
			                       
		}
		
		return risultato;
		
		
	}
	
	public Libretto votiUguali(int punteggio) {
		//meglio di tutte, retituisco un libretto
	
		Libretto risultato= new Libretto();
		
		for(Voto v: this.voti) {
		if(v.getVoto()==punteggio)
			risultato.add(v); //o anche libretto.voti.add(v)
		}
		return risultato;
		
	}
	
	public String toString() {
		String s="";
		for (Voto v: this.voti) {
			s+=v.toString()+ "\n";
			
		}
		return s;
		
	}
	

}
