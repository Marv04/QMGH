package upper.containertier;

import java.io.Serializable;
import java.util.ArrayList;

import user.Creator;
import user.Solver;
import verwaltung.Kurs;

public class Gesamtsystem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Creator> 	allCreators;
	private ArrayList<Solver> 	allSolvers;
	
	private ArrayList<Kurs> allKurse;
	
	public String signalString = "Hello World";

	public Gesamtsystem(ArrayList<Creator> allCreators, ArrayList<Solver> allSolvers, ArrayList<Kurs> allKurse) {
		super();
		this.allCreators 	= allCreators;
		this.allSolvers 	= allSolvers;
		this.allKurse 		= allKurse;
	}
	
	public ArrayList<Creator> getAllCreators(){
		return this.allCreators;
	}
	
	public ArrayList<Solver> getAllSolvers(){
		return this.allSolvers;
	}
	
	public ArrayList<Kurs> getAllKurse(){
		return this.allKurse;
	}
	
}
