package guiModules;

import java.util.ArrayList;

import umfrage.Fragebogen;
import upper.containertier.Gesamtsystem;
import user.Creator;
import verwaltung.Kurs;

public class FBDistributionModul {
	//Hier müssen 2 Kurse (Indize 0, 1) vorhanden sein...
	public static boolean distributeFB(Gesamtsystem targetSystem, boolean kursA, Fragebogen fbToBeDistributed, Creator requestingUser){
		try{
			ArrayList<Kurs> kursList = targetSystem.getAllKurse();
			if(kursA){
				requestingUser.distributeFragebogenTo(kursList.get(0), fbToBeDistributed);
			}else{
				requestingUser.distributeFragebogenTo(kursList.get(1), fbToBeDistributed);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
