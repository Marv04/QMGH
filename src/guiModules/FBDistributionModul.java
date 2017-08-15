package guiModules;

import umfrage.Fragebogen;
import upper.containertier.Gesamtsystem;
import user.Creator;

public class FBDistributionModul {
	//Hier müssen 2 Kurse (Indize 0, 1) vorhanden sein...
	public static boolean distributeFB(Gesamtsystem targetSystem, boolean kursA, Fragebogen fbToBeDistributed, Creator requestingUser){
		try{
			if(kursA){
				requestingUser.distributeFragebogenTo(targetSystem.getAllKurse().get(0), fbToBeDistributed);
			}else{
				requestingUser.distributeFragebogenTo(targetSystem.getAllKurse().get(1), fbToBeDistributed);
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
