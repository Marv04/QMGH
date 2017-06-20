package fragebogen;

import fragebogen.*;
import user.Mensch;

import java.util.ArrayList;

public class Creator extends Mensch{
	
	
	
	/*
	 * Operationen
	 */
	
	/*
	 * Nicht direkt ins Speichern eingegliedert
	 * 	Ggf. im Update-Zyklus erweiterbare Funktionalitäten durch diese Fragebogen-Initialisierung
	 */
	public Fragebogen createFragebogen(String titel, String exposee, ArrayList<Frage> fragen){
		return (new Fragebogen(titel, exposee, fragen));
	}
	
	
}
