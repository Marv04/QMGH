package verwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import auswertung.Fragebogenauswertung;
import user.Solver;

/**
 * 
 * @author Dominik<br><br>
 * 	The <CODE>Kurs</CODE> class contains an <CODE>ArrayList</CODE> of <CODE>Solver</CODE> <i>(pl.)</i>.<br>
 * 	The <CODE>Kurs</CODE> class is one of the <CODE>verwaltung</CODE> <i>(pl.)</i> classes bundling user groups for easier access. 
 * 	Distribution of data to the {@link user.Solver} <i>(pl.)</i> in the Fragebogen-system is managed through the <CODE>Kurs</CODE> class.
 *
 */
public class Kurs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * display name of the <CODE>Kurs</CODE> object
	 */
	private final String kursName;
	/**
	 * <CODE>ArrayList</CODE> of <CODE>Solver</CODE> <i>(pl.)</i> participating in the <CODE>Kurs</CODE>
	 */
	public final ArrayList<Solver> activeSolvers;
	
	/**
	 * <b><i>Kurs</i></b><br>
	 * &nbsp;&nbsp;&nbsp;<CODE>public Kurs(String kursName, ArrayList<Solver> activeSolvers)</CODE>
	 * constructs a <CODE>Kurs</CODE> with a display name and an <CODE>ArrayList</CODE> of {@link user.Solver} <i>(pl.)</i>
	 * 
	 * @param kursName - display name of the <CODE>Kurs</CODE> instance
	 * @param activeSolvers - <CODE>ArrayList</CODE> of Solvers participating in the <CODE>Kurs</CODE>
	 */
	public Kurs(String kursName, ArrayList<Solver> activeSolvers){
		super();
		this.kursName = kursName;
		this.activeSolvers = activeSolvers;
	}
	
	public String getKursName(){
		return this.kursName;
	}	
	
	/**
	 * Relays a <CODE>Fragebogen</CODE> object to all <CODE>Solver</CODE> <i>(pl.)</i> the <CODE>Kurs</CODE> object contains
	 * @param relayFragebogen - <CODE>Fragebogen</CODE> object to be relayed
	 */
	public void relayFragebogenToAllSolvers(Fragebogenauswertung antwortDestination){
		//Fügt dem Kurs eine Umfrage hinzu
		//Kp wie ArrayList.foreach funktioniert, sonst hätte ich das benutzt
		Iterator<Solver> activeSolverIt = this.activeSolvers.iterator();
		while(activeSolverIt.hasNext()){
			//Gibt den Solver Objekten Zugriff auf den Fragebogen aus dem Kurs weiter und fügt die Auswertungsreferenz hinzu
			activeSolverIt.next().addActiveFragebogenWithAntwortmoeglichkeit(antwortDestination.getSourceFragebogen().castToFragebogenWithAntwortmoeglichkeit(antwortDestination));
		}
	}

}
