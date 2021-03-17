package it.polito.tdp.librettovotiModel;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
	
	public static void main(String[] args) {
	
	  System.out.println("Test metodi di Libretto");	
	  Libretto libretto=new Libretto();
	
	  Voto voto1=new Voto("Analisi 1", 22, LocalDate.of(2019,  6, 27));
	
	  libretto.add(voto1);
	  libretto.add(new Voto("Fisica 1", 25, LocalDate.of(2021,  1, 18)));
	  libretto.add(new Voto("Informatica", 23, LocalDate.of(2019,  2, 1)));
	  
	  
	  
	  System.out.println(libretto);
	  
	  List<Voto> venticinque=libretto.listaVotiUguali(25);
	  System.out.println(venticinque); //è una arraylist il risultato, cambia la stampa
	  
	  Libretto librettoVenticinque= libretto.votiUguali(25);
	  System.out.println(librettoVenticinque); //è un oggetto diverso, cambia stampa e funzionalità
	  
	  Voto fisica=libretto.ricercaCorso("Fisica 1");
	  Voto fisica_doppio=new Voto("Fisica 1", 25, LocalDate.of(2021,  1, 18));
	  Voto fisica_conflitto=new Voto("Fisica 1", 28, LocalDate.of(2021,  1, 18));
	  
	  System.out.println(fisica + " doppione di " + fisica_doppio + "? --> " + libretto.esisteDuplicato(fisica_doppio));
	  
	  System.out.println(fisica + " conflitto con " + fisica_conflitto + "? --> " + libretto.esisteConflitto(fisica_conflitto));
	
	  //altri casi...
	  
	  
	  
	}
	

}
