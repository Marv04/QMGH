package hashes;

import java.util.ArrayList;

public class HashTable3D extends HashTable{
	private ArrayList<Integer> dimensionOneObjectID;
	private ArrayList<Integer> dimensionTwoObjectID;
	private ArrayList<ArrayList<Boolean>> hashValues;
	
	public HashTable3D(int hashTableID){
		super(hashTableID);
	}

	public ArrayList<Integer> getDimensionOneObjectID() {
		return this.dimensionOneObjectID;
	}
	public ArrayList<Integer> getDimensionTwoObjectID() {
		return this.dimensionTwoObjectID;
	}
	public ArrayList<ArrayList<Boolean>> getHashValues() {
		return this.hashValues;
	}
	
}
