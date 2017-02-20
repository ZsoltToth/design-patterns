package hu.uni.miskolc.iit.design.patterns.creational.factory.pcp.company;

public class Company {
	
	public static final int STORAGE_COUNT = 5;

	private static Company instance;
	
	private int nextStorageIndex;
	private Storage[] storages;
	
	private Company(){
		nextStorageIndex = 0;
		storages = new Storage[STORAGE_COUNT];
		for(int i = 0; i < STORAGE_COUNT; i++){
			storages[i] = new Storage();
		}
	}
	
	public static Company getCompany(){
		if(instance == null){
			instance = new Company();
		}
		return instance;
	}
	
	public Storage getStorage(){
		shiftNextStorageIndex();
		return storages[nextStorageIndex];
	}
	
	private void shiftNextStorageIndex(){
		nextStorageIndex = (nextStorageIndex + 1)%STORAGE_COUNT;
	}
}
