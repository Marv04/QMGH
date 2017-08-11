package guiModules;

import umfrage.Fragebogen;
import user.Creator;

public class FBRemovalModul {
	public static boolean removeFB(Creator fbCreator, Fragebogen fragebogenreferenz){
		if(fbCreator.getOwnedFrageboegen().remove(fragebogenreferenz)){
			return true;
		}
		return false;
	}
}
