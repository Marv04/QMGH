package hashes;

import java.util.ArrayList;

public class IDTable extends HashTable{
	private ArrayList<IDZuweisung> iDZuweisungen;
	
	public IDTable(int hashTableID, ArrayList<IDZuweisung> iDZuweisungen){
		super(hashTableID);
		this.iDZuweisungen = iDZuweisungen;
	}
	
	public ArrayList<IDZuweisung> getiDZuweisungen(){
		return this.iDZuweisungen;
	}
}
