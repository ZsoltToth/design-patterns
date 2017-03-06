package hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model;

public class Car {

	public enum CarAcceptability {
		unacc, acc, good, vgood
	}

	public enum BuyingPrice {
		vhigh, high, med, low
	}

	public enum MaintenancePrice {
		vhigh, high, med, low
	}

	public enum NumberOfDoors {
		two, three, four, fiveOrMore
	}

	public enum PersonCapacity {
		two, four, more
	}

	public enum LuggageBootSize {
		small, medium, big
	}

	public enum Safety {
		low, medium, high
	}

	private BuyingPrice buyingPrice;
	private MaintenancePrice maintenancePrice;
	private NumberOfDoors numberOfDoors;
	private PersonCapacity personCapacity;
	private LuggageBootSize luggageBootSize;
	private Safety safety;

	protected Car(BuyingPrice buyingPrice, MaintenancePrice maintenancePrice, NumberOfDoors numberOfDoors,
			PersonCapacity personCapacity, LuggageBootSize luggageBootSize, Safety safety) {
		super();
		this.buyingPrice = buyingPrice;
		this.maintenancePrice = maintenancePrice;
		this.numberOfDoors = numberOfDoors;
		this.personCapacity = personCapacity;
		this.luggageBootSize = luggageBootSize;
		this.safety = safety;
	}

	public BuyingPrice getBuyingPrice() {
		return buyingPrice;
	}

	public MaintenancePrice getMaintenancePrice() {
		return maintenancePrice;
	}

	public NumberOfDoors getNumberOfDoors() {
		return numberOfDoors;
	}

	public PersonCapacity getPersonCapacity() {
		return personCapacity;
	}

	public LuggageBootSize getLuggageBootSize() {
		return luggageBootSize;
	}

	public Safety getSafety() {
		return safety;
	}

}
