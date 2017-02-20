package hu.uni.miskolc.iit.design.patterns.creational.factory.pcp.company;

import java.util.HashMap;
import java.util.Map;

public class Storage {

	private Map<ProductType, Integer> inventory;
	
	protected Storage(){
		this.inventory = new HashMap<ProductType, Integer>();
	}
	
	public void deposit(ProductType product, Integer amount){
		if(!inventory.containsKey(product)){
			inventory.put(product, 0);
		}
		inventory.put(product, inventory.get(product) + amount);
	}
	
	public void withdraw(ProductType product, Integer amount) throws NotEnoughProductException {
		if(!inventory.containsKey(product)){
			throw new NotEnoughProductException("There is no "+product+" in the Storage");
		}
		if(inventory.get(product) < amount){
			throw new NotEnoughProductException("There is no "+product+" in the Storage");
		}
		inventory.put(product, inventory.get(product) - amount);
		
	}

	@Override
	public String toString() {
		return "Storage [inventory=" + inventory + "]";
	}
	
	
}
