package fragebogen;

import java.util.ArrayList;

public class Frage {
	/*
	 * Nähere Beschreibung der Frage
	 */
	private String fragebeschreibung;
	/*
	 * Single-Choice bzw. Multiple-Choice Status der Frage
	 * 	Für das Einlesen + Beantworten der Frage sowie die Auswertung
	 */
	private boolean singleChoice;
	/*
	 * Liste mit Antwortmöglichkeiten der Frage
	 */
	private ArrayList<String> antwortmoeglichkeiten;
	/*
	 * Numerischer Status der Frage
	 * 	Gibt an, ob alle Antwortmöglichkeiten einen numerischen Wert haben
	 * 	Für erweiterte Funktionen in der Auswertung
	 *  Ggf. erst im Update-Zyklus zu gebrauchen
	 */
	private boolean numeric;
	
	/*
	 * Konstruktor 
	 */
	public Frage(String fragebeschreibung, boolean singleChoice, ArrayList<String> antwortmoeglichkeiten, boolean numeric){
		this.fragebeschreibung = fragebeschreibung;
		this.singleChoice = singleChoice;
		this.antwortmoeglichkeiten = antwortmoeglichkeiten;
		this.numeric = numeric;
	}
	
	/*
	 * Getter.
	 * 	Nach der Initialisierung soll keine Bearbeitung des Fragebogens mehr möglich sein 
	 */
	
	public String getFragebeschreibung(){
		return this.fragebeschreibung;
	}
	
	public boolean isSingleChoice(){
		return this.singleChoice;
	}
	
	public ArrayList<String> getAntwortmoeglichkeiten(){
		return this.antwortmoeglichkeiten;
	}
	
	public boolean isNumeric(){
		return this.numeric;
	}
}
