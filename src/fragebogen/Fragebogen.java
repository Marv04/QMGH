package fragebogen;

import java.util.ArrayList;

public class Fragebogen {
	/*
	 * Hash-Wert für die Identifikation des Fragebogens (TBD!)
	 * Automatisch generiert
	 */
	//private String fragebogenID = ;
	/*
	 * Überschrift des Fragebogens
	 */
	private String titel;
	/*
	 * Nähere Beschreibung des Fragebogens
	 */
	private String exposee;
	/*
	 * Liste der Fragen
	 */
	private ArrayList<Frage> fragen;
	
	
	/*
	 * Konstruktor
	 * 	Cap der Frageanzahl ist 10, bei Überschreiten wird eine IndexOutOfBoundsException geworfen
	 * 	Cap der Antwortmöglichkeitenanzahl ist 5, bei Überschreiten wird eine IndexOutOfBoundsException geworfen
	 */
	protected Fragebogen(String titel, String exposee, ArrayList<Frage> fragen) throws IndexOutOfBoundsException{
		//this.fragebogenID = this.fragebogenID + "";
		this.titel = titel;
		this.exposee = exposee;
		if(fragen.size() < 1 || fragen.size() > 10 || fragen.size() < 1  || fragen.size() > 5){
			throw new IndexOutOfBoundsException();
		}
		this.fragen = fragen;
	}
	
	
	/*
	 * Getter.
	 * 	Nach der Initialisierung soll keine Bearbeitung des Fragebogens mehr möglich sein 
	 */
	
	/*
	 * public int getFragebogenID(){
		return this.fragebogenID;
	}
	*/
	
	public String getTitel(){
		return this.titel;
	}
	
	public String getExposee(){
		return this.exposee;
	}
	
	public ArrayList<Frage> getFragen(){
		return this.fragen;
	}

}
