package guiModules;

import java.util.ArrayList;

import auswertung.Fragebogenauswertung;
import user.Creator;

public class FBALoaderModul {
	public static ArrayList<Fragebogenauswertung> loadFBA(Creator requestingUser){
		return requestingUser.getOwnedFragebogenasuwertungen();
	}
}
