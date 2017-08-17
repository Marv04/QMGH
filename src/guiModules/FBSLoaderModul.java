package guiModules;

import java.util.ArrayList;

import umfrage.FragebogenWithAntwortmoeglichkeit;
import user.Solver;

public class FBSLoaderModul {
	public static ArrayList<FragebogenWithAntwortmoeglichkeit> loadFBS(Solver requestingUser){
		return requestingUser.getActiveFrageboegenWithAntwortmoeglichkeit();
	}
}
