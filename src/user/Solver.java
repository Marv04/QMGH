package user;

import java.io.Serializable;
import java.util.ArrayList;

import umfrage.FragebogenWithAntwortmoeglichkeit;

public class Solver extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FragebogenWithAntwortmoeglichkeit> activeFrageboegenWithAntwortmoeglichkeit;
	
	public Solver(String loginName, String passwort, String vorname, String nachname){
		super(loginName, passwort, vorname, nachname);
		this.activeFrageboegenWithAntwortmoeglichkeit = new ArrayList<FragebogenWithAntwortmoeglichkeit>();
	}
	
	public ArrayList<FragebogenWithAntwortmoeglichkeit> getActiveFrageboegenWithAntwortmoeglichkeit(){
		return this.activeFrageboegenWithAntwortmoeglichkeit;
	}
	
	public void addActiveFragebogenWithAntwortmoeglichkeit(FragebogenWithAntwortmoeglichkeit newFragebogenWithAntwortmoeglichkeit){
		this.activeFrageboegenWithAntwortmoeglichkeit.add(newFragebogenWithAntwortmoeglichkeit);
	}
	
	public void submitFragebogenergebnis(FragebogenWithAntwortmoeglichkeit fragebogenWithAntwortmoeglichkeit, ArrayList<ArrayList<Integer>> answers){
		if(this.activeFrageboegenWithAntwortmoeglichkeit.contains(fragebogenWithAntwortmoeglichkeit)){
			fragebogenWithAntwortmoeglichkeit.addAntwort(answers);
		}
	}
}
