package guiModules;

import java.util.ArrayList;

import umfrage.Frage;

public class FCreationModul {
	public static Frage createFrage(int frageTyp, String titel, ArrayList<String> antwortmoeglichkeiten){
		return (new Frage(titel, frageTyp, antwortmoeglichkeiten));
	}
}
