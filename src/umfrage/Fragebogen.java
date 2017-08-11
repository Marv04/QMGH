package umfrage;

import java.util.ArrayList;

import auswertung.Fragebogenauswertung;

public class Fragebogen implements Cloneable{
	private final  String titel;
	private final String exposee;
	private final ArrayList<Frage> fragen;
	
	public Fragebogen(String titel, String exposee, ArrayList<Frage> fragen){
		this.titel = titel;
		this.exposee = exposee;
		this.fragen = fragen;
	}

	public Object clone() { 
		try { 
			return super.clone(); 
		} catch (Exception e) { 
			return null; 
		} 
	}
	
	public String getTitel(){
		return this.titel;
	}
	public String getExposee(){
		return this.exposee;
	}
	public ArrayList<Frage> getFragen(){
		return this.fragen;
	}
	
	
	public FragebogenWithAntwortmoeglichkeit castToFragebogenWithAntwortmoeglichkeit(Fragebogenauswertung antwortDestination){
		return (new FragebogenWithAntwortmoeglichkeit(this.titel, this.exposee, this.fragen, antwortDestination));
	}
}
