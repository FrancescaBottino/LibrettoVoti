package it.polito.tdp.librettovotiModel;

import java.time.LocalDate;

public class TestLibretto {
	
	public static void main(String[] args) {
	
	  System.out.println("Test metodi di Libretto");	
	  Libretto libretto=new Libretto();
	
	  Voto voto1=new Voto("Analisi 1", 22, LocalDate.of(2019,  6, 27));
	
	  libretto.add(voto1);
	  libretto.add(new Voto("Fisica 1", 25, LocalDate.of(2021,  1, 18)));
	  libretto.add(new Voto("Informatica", 23, LocalDate.of(2019,  2, 1)));
	
	  
	  System.out.println(libretto);
	  
	}
	

}
