package tests;

import umfrage.*;
import upper.containertier.Gesamtsystem;
import user.Solver;
import verwaltung.Kurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import auswertung.Fragebogenauswertung;
import guiModules.PersistenzModul;

public class RunfreeTreiber {
	private static String savePath = "E:\\Massive Drive\\SOURCE\\Documents\\HWR";
	private static String dateiname = "testFilename";
	public static void main(String[] args){
		Scanner sa = new Scanner(System.in);
		
		Gesamtsystem myGesSys = new Gesamtsystem(null, null, null);
		
		System.out.println("Signalstring I ["+ myGesSys.signalString +"]");
		myGesSys.signalString = "Goodbye world!";
		
		System.out.println(PersistenzModul.saveGesamtsystem(savePath, dateiname, myGesSys));
		
		Gesamtsystem herGesSys = PersistenzModul.loadGesamtsystem(savePath, dateiname);
		
		System.out.println("Signalstring III ["+ herGesSys.signalString +"]");
		
		
		//System.out.println(getFragebogen(musterFB1()));
		/*
		Object obj = "lol";
		
		ArrayList<String> currentArrList = new ArrayList<String>();
		System.out.println("currentArrList.size() = "+ currentArrList.size()); 
		String bark = "Hello World";
		for(int i = 0; i < 10; i++){
			currentArrList.add("Number "+ i);
		}
		currentArrList.set(5, bark);
		bark = null;
		System.out.println("currentArrList.size() = "+ currentArrList.size() +"\n"); 
		
		Iterator<String> cAL = currentArrList.iterator();
		while(cAL.hasNext()){
			System.out.println(cAL.next());
		}
		*/
		
		Fragebogen musterFB1 = musterFB1();
		
		Fragebogenauswertung auswertung1 = new Fragebogenauswertung(musterFB1);
		
		/*Evtl besser: FBWAm aus FBA speisen? --> keine Redundanzdrohung... 
		
		FragebogenWithAntwortmoeglichkeit distr1 = auswertung1.getSourceFragebogen().castToFragebogenWithAntwortmoeglichkeit(auswertung1);
		
		answerFragebogen(sa, distr1);
		*/
		
		ArrayList<Solver> studenten = new ArrayList<Solver>();
		for(int i = 1; i <= 2; i++){
			studenten.add(musterSolver(i));
		}
		Kurs aKurs = musterKurs(1, studenten);
		aKurs.relayFragebogenToAllSolvers(auswertung1);

		System.out.println("KursSize=="+ aKurs.activeSolvers.size());
		submissionForEntireKurs(sa, aKurs);
		
		System.out.println(getAuswertung(auswertung1));
		
		/*
		Fragebogen myQuestions1 = createFragebogen(sa);
		System.out.println(getFragebogen(myQuestions1));
		
		Frage myQuestion1 = createFrage(sa);
		System.out.println(getFrage(myQuestion1));
		*/
		sa.close();
	}
	
	/*
	private static Frage createFrage(Scanner sa){
		System.out.println("Fragebeschreibung? [Text]");
		String fragebeschreibung = sa.nextLine();
		System.out.println("SingleChoice? [true / false]");
		boolean singleChoice = sa.nextBoolean(); sa.nextLine();
		System.out.println("NumericAnswersOnly? [true / false]");
		boolean numericAnswersOnly = sa.nextBoolean(); sa.nextLine();
		int anzahl = 0;
		do{
			System.out.println("Anzahl der Antwortmöglichkeiten? [Zahl zw. 1 und 5]");
			anzahl = sa.nextInt(); sa.nextLine();
		}while(anzahl < 1 || anzahl > 5);
		ArrayList<String> antwortmoeglichkeiten = new ArrayList<String>();
		for(; anzahl > 0; anzahl--){
			System.out.println("Antwortmöglichkeit? [Text]");
			antwortmoeglichkeiten.add(sa.nextLine());
		}
		return (new Frage(fragebeschreibung, singleChoice, numericAnswersOnly, antwortmoeglichkeiten));
	}
	*/
	private static String getFrage(Frage toBeGetted){
		String returnString = ""
				+ "Beschreibung: \n"+ toBeGetted.getFragebeschreibung() + "\n"
				//+ "SingleChoice: \n"+ toBeGetted.isSingleChoice() + "\n"
				//+ "NumericAnswersOnly: \n"+ toBeGetted.hasNumericAnswersOnly() + "\n"
				+ "Antwortmöglichkeiten:";
		Iterator<String> myAntwIt = toBeGetted.getAntwortmoeglichkeiten().iterator();
		int i = 1;
		while(myAntwIt.hasNext()){
			returnString += "\n"+ i++ +". "+ myAntwIt.next();
		}
		return returnString;
	}
	/*
	private static Fragebogen createFragebogen(Scanner sa){
		System.out.println("Titel? [Text]");
		String titel = sa.nextLine();
		System.out.println("Exposee?[Text]");
		String exposee = sa.nextLine();
		int anzahl = 0;
		do{
			System.out.println("Anzahl Fragen [Zahl zw. 1 und 10]");
			anzahl = sa.nextInt(); sa.nextLine();
		}while(anzahl < 1 || anzahl > 10);
		ArrayList<Frage> fragen = new ArrayList<Frage>();
		for(; anzahl > 0; anzahl--){
			fragen.add(createFrage(sa));
		}
		return (new Fragebogen(titel, exposee, fragen));
	}
	*/
	/*
	private static String getFragebogen(Fragebogen toBeGetted){
		String returnString = ""
				+ "Titel: \n"+ toBeGetted.getTitel() + "\n"
				+ "Exposee: \n"+ toBeGetted.getExposee();
		Iterator<Frage> myFBIt = toBeGetted.getFragen().iterator();
		while(myFBIt.hasNext()){
			returnString += "\n"+ getFrage(myFBIt.next());
		}
		return returnString;
	}
	*/
	private static Fragebogen musterFB1(){
		String titel = "Auswahl einer Lieblingsfarbe";
		String exposee  = "Aufgrund der vermehrten Nachfrage nach Farben, soll nun ermittelt werden, welche Farbe die beliebteste ist.";
		
		String fragebeschreibung;
		ArrayList<String> antwortmoeglichkeiten;
		
		fragebeschreibung = "Wie viele Lieblingsfarben haben sie?";
		antwortmoeglichkeiten = new ArrayList<String>();
		for(int i = 1; i <= 5; i++){
			antwortmoeglichkeiten.add("" + i);
		}
		Frage frage1 = new Frage(fragebeschreibung, 0, antwortmoeglichkeiten);
		
		fragebeschreibung = "Ist ihre Lieblings-'farbe' schwarz oder weiß?";
		antwortmoeglichkeiten = new ArrayList<String>();
		antwortmoeglichkeiten.add("Ja");
		antwortmoeglichkeiten.add("Nein");
		Frage frage2 = new Frage(fragebeschreibung, 0, antwortmoeglichkeiten);

		fragebeschreibung = "Was sind ihre Lieblingsfarben?";
		antwortmoeglichkeiten = new ArrayList<String>();
		antwortmoeglichkeiten.add("Blau");
		antwortmoeglichkeiten.add("Gelb");
		antwortmoeglichkeiten.add("Rot");
		antwortmoeglichkeiten.add("Grün");
		antwortmoeglichkeiten.add("Orange");
		Frage frage3 = new Frage(fragebeschreibung, 0, antwortmoeglichkeiten);
		
		ArrayList<Frage> returnFragen = new ArrayList<Frage>();
		returnFragen.add(frage1);
		returnFragen.add(frage2);
		returnFragen.add(frage3);
		
		return (new Fragebogen(titel, exposee, returnFragen));
	}
	private static Kurs musterKurs(int index, ArrayList<Solver> activeSolvers){
		return (new Kurs("WI16-"+index, activeSolvers));
	}
	private static Solver musterSolver(int index){
		return (new Solver("s_muster", "pw"+ index, "Student"+ index, "Mustermann"));
	}
	
	private static ArrayList<ArrayList<Integer>> createAndReturnFragebogenAnswer(Scanner sa, FragebogenWithAntwortmoeglichkeit testUmfrage){
		Iterator<Frage> testUmfrageIt = testUmfrage.getFragen().iterator();
		ArrayList<ArrayList<Integer>> answers1 = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> subArrIntList;
		while(testUmfrageIt.hasNext()){
			System.out.println(getFrage(testUmfrageIt.next()));
			subArrIntList = new ArrayList<Integer>();
			//Vorerst singleChoice
			subArrIntList.add(sa.nextInt() - 1); sa.nextLine();
			answers1.add(subArrIntList);
		}
		
		return answers1;
	}
	
	private static void submissionForEntireKurs(Scanner sa, Kurs testKurs){
		Iterator<Solver> localIt = testKurs.activeSolvers.iterator();
		Solver subSolver;
		FragebogenWithAntwortmoeglichkeit subjectFragebogen;
		System.out.println("KursSize=="+ testKurs.activeSolvers.size());
		while(localIt.hasNext()){
			subSolver = localIt.next();
			System.out.println(subSolver.testReturnAllFB());
			subjectFragebogen = subSolver.getActiveFragebogenWithAntwortmoeglichkeit().get(0);
			subSolver.submitFragebogenergebnis(subjectFragebogen, createAndReturnFragebogenAnswer(sa, subjectFragebogen));
		}
	}
	
	private static String getAuswertung(Fragebogenauswertung toBeGetted){
		String returnString = "";
		
		returnString += "FBA: \n"
				+ "Titel: \n"+ toBeGetted.getSourceFragebogen().getTitel() +"\n"
				+ "Exposee: \n"+ toBeGetted.getSourceFragebogen().getExposee() +"\n";
		
		Iterator<Frage> questionCounter = toBeGetted.getSourceFragebogen().getFragen().iterator();
		Frage subQuestion;
		Iterator<String> answerCounter;
		for(int q = 0; questionCounter.hasNext(); q++){
			subQuestion = questionCounter.next();
			
			returnString += subQuestion.getFragebeschreibung() +"\n";
			
			answerCounter = subQuestion.getAntwortmoeglichkeiten().iterator();
			//System.out.println("size=="+ toBeGetted.getAllAntworten().size());
			for(int a = 0; answerCounter.hasNext(); a++){
				returnString += answerCounter.next() + "\n"
						+ "Gewählt von: "+ toBeGetted.getAllAntworten().get(q).get(a) +"\n";
			}
		}
		
		return returnString;
	}
	
}

