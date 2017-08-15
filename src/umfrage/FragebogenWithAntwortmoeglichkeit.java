package umfrage;

import java.io.Serializable;
import java.util.ArrayList;

import auswertung.Fragebogenauswertung;

public class FragebogenWithAntwortmoeglichkeit extends Fragebogen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fragebogenauswertung antwortDestination;
	
	public FragebogenWithAntwortmoeglichkeit(String titel, String exposee, ArrayList<Frage> fragen, Fragebogenauswertung antwortDestination){
		super(titel, exposee, fragen);
		this.antwortDestination = antwortDestination;
	}
	
	public void addAntwort(ArrayList<ArrayList<Integer>> antwort){
		this.antwortDestination.addAntwort(antwort);
	}
	
	
}
