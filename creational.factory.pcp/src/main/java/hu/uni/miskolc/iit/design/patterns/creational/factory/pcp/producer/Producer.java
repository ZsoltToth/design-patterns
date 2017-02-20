package hu.uni.miskolc.iit.design.patterns.creational.factory.pcp.producer;

import hu.uni.miskolc.iit.design.patterns.creational.factory.pcp.company.ProductType;
import hu.uni.miskolc.iit.design.patterns.creational.factory.pcp.company.Storage;

public class Producer implements Runnable {

	private Storage storage;
	private ProductType product;
	private long delayOfProduction;
	private final int shippedAmount;
	private int totalAmount;

	public Producer(Storage storage, ProductType product, long delayOfProduction, int shippedAmount, int totalAmount) {
		super();
		this.storage = storage;
		this.product = product;
		this.delayOfProduction = delayOfProduction;
		this.shippedAmount = shippedAmount;
		this.totalAmount = totalAmount;
	}

	public void run() {
		while(totalAmount > 0){
			storage.deposit(product, shippedAmount);
			totalAmount -= shippedAmount; // bug
			try {
				Thread.sleep(delayOfProduction);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
