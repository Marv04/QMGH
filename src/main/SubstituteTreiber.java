package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import user.Creator;
import fragebogen.*;

public class SubstituteTreiber {
	public static void mainRun(){
		Scanner sa = new Scanner(System.in);
		
		Creator firstCreator = new Creator();
		ArrayList<Fragebogen> firstFrageboegen = new ArrayList<Fragebogen>();
		
		boolean fortsetzen = true;
		do{
			System.out.println(optionAnzeige01());
			switch(sa.nextLine()){
			case "0":
				firstFrageboegen.add(createFragebogen(sa, firstCreator));
				break;
			case "1":
				System.out.println("Den wievielten (von Null an)?");
				try{
					int index = sa.nextInt();
					System.out.println(readFragebogen(firstFrageboegen.get(index)));
				}catch(Exception e){
					System.out.println(e.toString());
				}
				sa.nextLine();
				break;
			case "2":
				fortsetzen = false;
				break;
			default:
				System.out.println("Ungültige Eingabe...");
			}
		}while(fortsetzen);
		sa.close();
	}
	
	private static String[] options(){
		String[] returnOptions = new String[3];
		
		returnOptions[0] = "Fragebogen erstellen";
		returnOptions[1] = "Fragebogen (irgendwie) ansehen - in dieser Form NUR zu demonstrativen Zwecken";
		returnOptions[2] = "Programm beenden (und jeglichen Fortschritt löschen!)";
		
		return returnOptions;
	}
	private static String optionAnzeige01() {
		String returnString = "";
		for(int i = 0; i < options().length; i++){
			returnString += i + ": " + options()[i] + "\n";
		}
		return returnString;
	}
	
	/*
	 * Satanistisch langes Stück Code, lol
	 */
	private static Frage createFrage(Scanner sa){
		boolean exceptionPresent = true;
		/*
		 * Frage.fragebeschreibung
		 */
		System.out.println("Fragebeschreibung angeben!");
		String fragebeschreibung = sa.nextLine();
		/*
		 * Frage.singleChoice
		 */
		boolean singleChoice = false;
		do{
			System.out.println("Single-Choice [true] oder [false] angeben!");
			try{
				singleChoice = sa.nextBoolean();
				exceptionPresent = false;
			}catch(Exception e){
				System.out.println(e.toString());
				exceptionPresent = true;
			}
			sa.nextLine();
		}while(exceptionPresent);
		exceptionPresent = false;
		/*
		 * Frage.antwortMoeglichkeiten
		 */
		ArrayList<String> antwortmoeglichkeiten = new ArrayList<String>();
		int anzahlAntwortmoeglichkeiten = 0;
		do{
			System.out.println("Anzahl der Antwortmöglichkeiten angeben (größergleich 1, kleinergleich 5)!");
			try{
				anzahlAntwortmoeglichkeiten = Integer.parseInt(sa.nextLine());
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}while(anzahlAntwortmoeglichkeiten < 1 || anzahlAntwortmoeglichkeiten > 5);
		for(int i = 0; i < anzahlAntwortmoeglichkeiten; i++){
			System.out.println("Antwortmöglichkeit "+ (i+1) +" angeben!");
			antwortmoeglichkeiten.add(sa.nextLine());
		}
		/*
		 * Frage.numeric
		 */
		boolean numeric = false;
		do{
			System.out.println("Numerischen Status der Frage [true] oder [false] angeben!");
			try{
				numeric = sa.nextBoolean();
				exceptionPresent = false;
			}catch(Exception e){
				System.out.println(e.toString());
				exceptionPresent = true;
			}
			sa.nextLine();
		}while(exceptionPresent);
		/*
		 * return
		 */
		return (new Frage(fragebeschreibung, singleChoice, antwortmoeglichkeiten, numeric));
	}

	private static Fragebogen createFragebogen(Scanner sa, Creator initiator){
		/*
		 * Fragebogen.titel
		 */
		System.out.println("Titel angeben!");
		String titel = sa.nextLine();
		/*
		 * Fragebogen.exposee
		 */
		System.out.println("Exposee angeben!");
		String exposee = sa.nextLine();
		/*
		 * Fragebogen.fragen
		 */
		ArrayList<Frage> fragen = new ArrayList<Frage>();
		int anzahlFragen = 0;
		do{
			System.out.println("Anzahl der Fragen angeben (größergleich 1, kleinergleich 10)!");
			try{
				anzahlFragen = Integer.parseInt(sa.nextLine());
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}while(anzahlFragen < 1 || anzahlFragen > 10);
		for(int i = 0; i < anzahlFragen; i++){
			System.out.println("\nFrage ("+ (i+1) +")");
			fragen.add(createFrage(sa));
		}
		
		return initiator.createFragebogen(titel, exposee, fragen);
	}

	private static String readFragebogen(Fragebogen inputFragebogen){
		String returnString = "";
		
		returnString += "Titel:\n"+ inputFragebogen.getTitel() +"\n\n";
		returnString += "Exposee:\n"+ inputFragebogen.getExposee() +"\n\n";
		returnString += "Fragen:\n\n";
		//Durchläuft alle Fragen
		for(int i = 0; i < inputFragebogen.getFragen().size(); i++){
			returnString += "("+ i +")"+ inputFragebogen.getFragen().get(i).getFragebeschreibung() +"\n";
			//Durchläuft alle Antwortmöglichkeiten
			for(int j = 0; j < inputFragebogen.getFragen().get(i).getAntwortmoeglichkeiten().size(); j++){
				returnString += "- "+ inputFragebogen.getFragen().get(i).getAntwortmoeglichkeiten().get(j) +"\n";
			}
		}
		return returnString;
	}
}
