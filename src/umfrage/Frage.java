package umfrage;

import java.util.ArrayList;

public class Frage {
	private final String fragebeschreibung;
	private final int frageTyp;
	private final ArrayList<String> antwortmoeglichkeiten;
	
	public Frage(String fragebeschreibung, int frageTyp, ArrayList<String> antwortmoeglichkeiten) {
		this.fragebeschreibung = fragebeschreibung;
		this.frageTyp = frageTyp;
		this.antwortmoeglichkeiten = antwortmoeglichkeiten;
	}
	
	public String getFragebeschreibung(){
		return this.fragebeschreibung;
	}
	public int getFragetyp(){
		return this.frageTyp;
	}
	public ArrayList<String> getAntwortmoeglichkeiten(){
		return this.antwortmoeglichkeiten;
	}
}
