package umfrage;

import java.io.Serializable;
import java.util.ArrayList;

public class Frage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
