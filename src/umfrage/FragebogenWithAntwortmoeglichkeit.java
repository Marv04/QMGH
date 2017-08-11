package umfrage;

import java.util.ArrayList;

import auswertung.Fragebogenauswertung;

public class FragebogenWithAntwortmoeglichkeit extends Fragebogen{
	private Fragebogenauswertung antwortDestination;
	
	public FragebogenWithAntwortmoeglichkeit(String titel, String exposee, ArrayList<Frage> fragen, Fragebogenauswertung antwortDestination){
		super(titel, exposee, fragen);
		this.antwortDestination = antwortDestination;
	}
	
	public void addAntwort(ArrayList<ArrayList<Integer>> antwort){
		this.antwortDestination.addAntwort(antwort);
	}
	
	
}
