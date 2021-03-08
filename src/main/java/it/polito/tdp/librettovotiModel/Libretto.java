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
	
	public String toString() {
		String s="";
		for (Voto v: this.voti) {
			s+=v.toString()+ "\n";
			
		}
		return s;
		
	}
	

}
