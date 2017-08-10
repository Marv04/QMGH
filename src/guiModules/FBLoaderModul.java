package guiModules;

import java.util.ArrayList;

import umfrage.Fragebogen;
import user.Creator;

public class FBLoaderModul {
	public static ArrayList<Fragebogen> loadFB(Creator requestingUser){
		return requestingUser.getOwnedFrageboegen();
	}
}
