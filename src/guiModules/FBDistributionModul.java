package guiModules;

import umfrage.Fragebogen;
import user.Creator;
import verwaltung.Kurs;

public class FBDistributionModul {
	//Hier müssen 2 Kurse (Indize 0, 1) vorhanden sein...
	public static boolean distributeFB(Kurs targetKurs, Fragebogen fbToBeDistributed, Creator requestingUser){
		try{
			requestingUser.distributeFragebogenTo(targetKurs, fbToBeDistributed);
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
