package guiModules;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import upper.containertier.Gesamtsystem;

public class PersistenzModul {
	private static String dateityp = ".wi16";
	
	public static boolean saveGesamtsystem(String speicherort, String dateiname, Gesamtsystem gesSysToBeSaved){
		try{
			FileOutputStream gesSysFileOut = new FileOutputStream(speicherort +"\\"+ dateiname + dateityp);
			ObjectOutputStream gesSysObjectOut = new ObjectOutputStream(gesSysFileOut);
			
			gesSysObjectOut.writeObject(gesSysToBeSaved);
			
			gesSysObjectOut.close();
			gesSysFileOut.close();
		}catch(Exception e){
			//System.out.println("Attentione! "+ e.toString());
			return false;
		}
		return true;
	}
	
	public static Gesamtsystem loadGesamtsystem(String dateipfad, String dateiname){
		try{
			FileInputStream gesSysFileIn = new FileInputStream(dateipfad +"\\"+ dateiname + dateityp);
			ObjectInputStream gesSysObjectIn = new ObjectInputStream(gesSysFileIn);
			
			return (Gesamtsystem) gesSysObjectIn.readObject();
		}catch(Exception e){
			return null;
		}
	}
}
