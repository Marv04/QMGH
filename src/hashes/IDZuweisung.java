package hashes;

public class IDZuweisung {
	private int objectIDPrefix;
	private Class correspondingClass;
	
	protected IDZuweisung(int objectIDPrefix, Class correspondingClass){
		this.objectIDPrefix = objectIDPrefix;
		this.correspondingClass = correspondingClass;
	}
	
	public int getObjectIDPrefix(){
		return this.objectIDPrefix;
	}
	public Class getCorrespondingClass(){
		return this.correspondingClass;
	}

}
