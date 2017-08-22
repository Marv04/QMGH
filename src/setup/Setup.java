package setup;

import java.util.ArrayList;
import java.util.Scanner;

import guiModules.FBDistributionModul;
import guiModules.PersistenzModul;
import umfrage.Frage;
import umfrage.FragebogenWithAntwortmoeglichkeit;
import upper.containertier.Gesamtsystem;
import user.Creator;
import user.Solver;
import verwaltung.Kurs;

public class Setup {
	private static String savePath = "";
	private static String dateiname = "QuestionMarkFile";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		savePath = scan.nextLine();
		scan.close();
		
		//Genrierung Solver Accounts -> Kurs A
		ArrayList<Solver> solverList = new ArrayList<Solver>();
		
			//Anlegen von dem Admin Account -> Kurs A
			solverList.add(new Solver("sAdminA", "HWR_Admin", "Max", "Mustermann"));
			//Reguläre Accounts - 15 Stück -> Kurs A
			solverList.add(new Solver("sZimmManf", "kEstu8eq", "Manfred", "Zimmermann"));
			solverList.add(new Solver("sHeinJoch", "SpupHU4e", "Jochim", "Heintze"));
			solverList.add(new Solver("sWoerLore", "kusaFr5W", "Lorenz", "Woerner"));
			solverList.add(new Solver("sBranMose", "Stan4vEc", "Mose", "Von Brandt"));
			solverList.add(new Solver("sHarmEwal", "m7guCesw", "Ewald", "Harman"));
			solverList.add(new Solver("sMendHans", "cre5UTru", "Hans", "Mendelssohn"));
			solverList.add(new Solver("sSchrDiet", "5edujEMe", "Dietmar", "Schroeter"));
			solverList.add(new Solver("sHummCorn", "s7pawadE", "Cornelius", "Hummel"));
			solverList.add(new Solver("sBierNath", "dre6usWu", "Nathalie", "Biermann"));
			solverList.add(new Solver("sJansLili", "6uphAwRU", "Lili", "Jans"));
			solverList.add(new Solver("sPaulCami", "Re7recre", "Camilla", "Paul"));
			solverList.add(new Solver("sSommVere", "p6asusTa", "Verena", "Sommer"));
			solverList.add(new Solver("sSchmFran", "QadreT8S", "Franzi", "Schmitt"));
			solverList.add(new Solver("sWittMari", "truc4duF", "Marie", "Witt"));
			solverList.add(new Solver("sKoenNico", "zUne2apH", "Nicol", "Koenigsmann"));
		
		//Generierung Solver Accounts -> Kurs B
		ArrayList<Solver> solverListB = new ArrayList<Solver>();
		
			//Anlegen von dem Admin Account -> Kurs B
			solverListB.add(new Solver("sAdminB", "HWR_Admin", "Max", "Mustermann"));
			//Reguläre Accounts - 15 Stück -> Kurs B
			solverListB.add(new Solver("sWebeTher","qaWR2mUw","Theresia","Weber"));
			solverListB.add(new Solver("sBrauSonj","6Ecaprup","Sonja","Braune"));
			solverListB.add(new Solver("sGroßTheo","vajup4tH","Theodor","Große"));
			solverListB.add(new Solver("sSternUtz","wraT7aca","Utz","Sternberg"));
			solverListB.add(new Solver("sBohnRose","xeFrEP7e","Rosemarie","Bohn"));
			solverListB.add(new Solver("sBierAmel","fraG7nuw","Amelia","Biermann"));
			solverListB.add(new Solver("sKlosRuth","ph4tHEwE","Ruth","Klossner"));
			solverListB.add(new Solver("sMessAgat","tR2VewuB","Agathe","Messerli"));
			solverListB.add(new Solver("sEsseKnut","DAsaSwa3","Knut","Essert"));
			solverListB.add(new Solver("sEbneMarc","xa4Ustut","Marco","Ebner"));
			solverListB.add(new Solver("sLandJoac","buchE4He","Joachim","Landau"));
			solverListB.add(new Solver("sWangEgon","paWr5BUf","Egon","Wang"));
			solverListB.add(new Solver("sLoriCori","Ve2ACram","Corinna","Loris"));
			solverListB.add(new Solver("sSchwGunt","tuPhu4hA","Gunther","Schwarz"));
			solverListB.add(new Solver("sSeelAria","xak6trAc","Ariane","Seelenfreund"));
			
			
		//Generierung der Kursliste	
		ArrayList<Kurs> kursList = new ArrayList<Kurs>();
			//Generierung der zwei Kurse A/B & Zuordnung
			kursList.add(new Kurs("A", solverList));
			kursList.add(new Kurs("B", solverListB));
			
		//Generierung Creator Accounts 
		ArrayList<Creator> creatorList = new ArrayList<Creator>();	
			//Reguläre Creator Accounts - 5 Stück
			creatorList.add(new Creator("cSchmietendorf", "abc", "Andreas", "Schmietendorf", kursList));
		
		//Generierung Gesamt Solver Liste
		ArrayList<Solver> solverGlobal = new ArrayList<Solver>();
			//Hinzufügen der zwei Solver Listen
			solverGlobal.addAll(solverList);
			solverGlobal.addAll(solverListB);
		
		//Erstellen des Gesamtsystems
		Gesamtsystem myGesSys = new Gesamtsystem(creatorList, solverGlobal, kursList);
		
		//Speichern des Gesamtsystems
		PersistenzModul.saveGesamtsystem(savePath, dateiname, myGesSys);
		
	}

		
		
}


