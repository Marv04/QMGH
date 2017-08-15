package guiModules;

import java.util.ArrayList;
import java.util.Iterator;

import umfrage.Frage;
import umfrage.Fragebogen;
import user.Creator;

public class FBCreationModul {
	public static boolean createFB(Creator fbCreator, String titel, String exposee, String[][] frageDaten){
		try{
			ArrayList<Frage> frageList = new ArrayList<Frage>();
			
			ArrayList<String> antwortmoeglichkeitenShell;
			for(int i = 0; i < frageDaten.length; i++){
				antwortmoeglichkeitenShell = new ArrayList<String>();
				for(int j = 0; j < frageDaten[2].length; j++){
					antwortmoeglichkeitenShell.add(frageDaten[i][j]);
				}
				frageList.add(FCreationModul.createFrage(Integer.parseInt(frageDaten[i][0]), frageDaten[i][1], antwortmoeglichkeitenShell));
			}
			
			fbCreator.addOwnedFragebogen(new Fragebogen(titel, exposee, frageList));
		}catch(Exception e){
			//Falls Fehler bei der Anlage unterläuft
			return false;
		}
		return true;
	}
}
