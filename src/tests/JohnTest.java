package tests;

import java.io.Serializable;
import java.util.ArrayList;

import guiModules.FBDistributionModul;
import guiModules.PersistenzModul;
import umfrage.Frage;
import umfrage.FragebogenWithAntwortmoeglichkeit;
import upper.containertier.Gesamtsystem;
import user.Creator;
import user.Solver;
import verwaltung.Kurs;

public class JohnTest implements Serializable{
	private static String savePath = "C:\\OOP - Projekt";
	private static String dateiname = "testFilenameNEW";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Creator> creatorList = new ArrayList<Creator>();
		ArrayList<Kurs> kursList = new ArrayList<Kurs>();
		ArrayList<Solver> solverGlobal = new ArrayList<Solver>();
		ArrayList<Solver> solverList = new ArrayList<Solver>();
		ArrayList<Solver> solverListB = new ArrayList<Solver>();
		solverList.add(new Solver("sAdminA", "abc", "John", "Doe2A"));
		solverListB.add(new Solver("sAdminB", "abc", "JohnB", "Doe2B"));
		creatorList.add(new Creator("cAdmin", "abc", "John", "Doe", kursList));
		kursList.add(new Kurs("A", solverList));
		kursList.add(new Kurs("B", solverListB));
		ArrayList<Frage> fragen = new ArrayList<Frage>();
		ArrayList<String> antworten = new ArrayList<String>();
		antworten.add("ABCDEFG");
		fragen.add(new Frage("Was?", 1, antworten));
		FragebogenWithAntwortmoeglichkeit fb = new FragebogenWithAntwortmoeglichkeit("Titel FB Test", "Expose FB", fragen, null);
		
		solverGlobal.addAll(solverList);
		solverGlobal.addAll(solverListB);
		
		Gesamtsystem myGesSys = new Gesamtsystem(creatorList, solverGlobal, kursList);
		System.err.println(FBDistributionModul.distributeFB(myGesSys, true, fb, creatorList.get(0)));
		
		Gesamtsystem myGesSys2 = new Gesamtsystem(null,null,null);
		PersistenzModul.saveGesamtsystem(savePath, dateiname, myGesSys);
		
		//Gesamtsystem gesSys = PersistenzModul.loadGesamtsystem(savePath, dateiname);
		//System.out.println(gesSys);
	}

}
