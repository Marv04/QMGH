package guiModules;

import java.util.ArrayList;

import umfrage.Frage;
import umfrage.Fragebogen;
import user.Creator;

public class FBCreationModul {
	public static boolean createFB(Creator fbCreator, String titel, String exposee, ArrayList<Frage> fragenListInput){
		try{
			ArrayList<Frage> frageList = new ArrayList<Frage>();
			
			fbCreator.addOwnedFragebogen(new Fragebogen(titel, exposee, fragenListInput));
		}catch(Exception e){
			//Falls Fehler bei der Anlage unterläuft
			return false;
		}
		return true;
	}
}
