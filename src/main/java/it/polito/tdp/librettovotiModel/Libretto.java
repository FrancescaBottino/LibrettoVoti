package it.polito.tdp.librettovotiModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Libretto {
	
	//contiene al suo interno dei voti
	
	private List<Voto> voti;
	private Map<String, Voto> votiMap; //identity map
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();
		votiMap= new HashMap<String, Voto>();
		
		
	}
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNomeCorso(), v);
		
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
	/**
	 * Ricerca un voto del corso cui è specificato il nome
	 * se non esiste restituisce  null
	 * 
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		
		/*Voto risultato=null;
		
		for(Voto v: this.voti) {
			if(v.getNomeCorso().equals(nomeCorso)) {
				risultato=v;
				break;  //prendo solo il primo
			}
			
		}
		return risultato;
		*/
		
		//mappa
		
		return this.votiMap.get(nomeCorso);
		
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la stessa votazione
	 * @param v
	 * @return
	 */
	
	public boolean esisteDuplicato(Voto v) {
		//forse era meglio usare mappa che this.voti
		
		/*boolean trovato=false;
		
		for(Voto voto: this.voti) {
			if(voto.getNomeCorso().equals(v.getNomeCorso()) && voto.getVoto()==v.getVoto())
				trovato=true;
			       break;
		}
		return trovato;*/
		
		//mappa, più veloce
		
		Voto trovato=this.votiMap.get(v.getNomeCorso());
		if(trovato==null)
			return false;
		
		if(trovato.getVoto()==v.getVoto())
			return true;
		else 
			return false;
		
		
		
	}
	
	/**
	 * Verifica se nl libretto c'è già un voto con lo stesso esame ma votazione diversa
	 * @return
	 */
	
	public boolean esisteConflitto(Voto v) {
		
       /*boolean trovato=false;
		
		for(Voto voto: this.voti) {
			if(voto.getNomeCorso().equals(v.getNomeCorso()) && voto.getVoto()!=v.getVoto())
				trovato=true;
			       break;
		}
		return trovato;*/
		
		//mappa
		
		Voto trovato=this.votiMap.get(v.getNomeCorso());
		if(trovato==null)
			return false;
		
		if(trovato.getVoto()!=v.getVoto())
			return true;
		else 
			return false;

		
	}
	
	public String toString() {
		String s="";
		for (Voto v: this.voti) {
			s+=v.toString()+ "\n";
			
		}
		return s;
		
	}
	

}
