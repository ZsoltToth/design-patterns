package hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model.Car;

public class CarReader {

	public Map<Car, Car.CarAcceptability> readTrainingSet(File input) {
		Map<Car, Car.CarAcceptability> result = new HashMap<Car, Car.CarAcceptability>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = null;
			while ((line = reader.readLine()) != null) {
				Car car = extractCar(line);
				Car.CarAcceptability acceptability = extractAcceptability(line);
				if (car == null || acceptability == null) {
					continue;
				}
				result.put(car, acceptability);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private Car extractCar(String line) {
		Car result = null;
		String[] fields = line.split(",");
		if (fields.length != 7) {
			return result;
		}
		Car.BuyingPrice buyingPrice = Car.BuyingPrice.valueOf(fields[0]);
		Car.MaintenancePrice maintenancePrice = Car.MaintenancePrice.valueOf(fields[1]);
		Car.NumberOfDoors numberOfDoors = null;
		switch (fields[2]) {
		// (doors: 2, 3, 4, 5more) -> (two, three, four, fiveOrMore)
		case "2":
			numberOfDoors = Car.NumberOfDoors.two;
			break;
		case "3":
			numberOfDoors = Car.NumberOfDoors.three;
			break;
		case "4":
			numberOfDoors = Car.NumberOfDoors.four;
			break;
		case "5more":
			numberOfDoors = Car.NumberOfDoors.fiveOrMore;
			break;
		default:
			return result;
		}
		Car.PersonCapacity personCapacity = null;
		switch (fields[3]) {
		// ( 2, 4, more) -> (two, four, more)
		case "2":
			personCapacity = Car.PersonCapacity.two;
			break;
		case "4":
			personCapacity = Car.PersonCapacity.four;
			break;
		case "more":
			personCapacity = Car.PersonCapacity.more;
			break;
		default:
			return result;
		}
		Car.LuggageBootSize luggageBootSize = null;
		switch(fields[4]){
		// ( small, med, big) -> (small, medium, big)
		case "small" : luggageBootSize = Car.LuggageBootSize.small; break;
		case "med" : luggageBootSize = Car.LuggageBootSize.medium; break;
		case "big" : luggageBootSize = Car.LuggageBootSize.big; break;
		default : return result;
		}
		Car.Safety safety = null;
		switch(fields[5]){
		// (low, med, high) -> (low, medium, high)
		case "low" : safety = Car.Safety.low; break;
		case "med" : safety = Car.Safety.medium; break;
		case "high" : safety = Car.Safety.high; break;
		default : return result;
		}
		result = new Car(buyingPrice, maintenancePrice, numberOfDoors, personCapacity, luggageBootSize, safety);
		return result;
	}

	private Car.CarAcceptability extractAcceptability(String line) {
		Car.CarAcceptability result = null;
		String[] fields = line.split(",");
		if (fields.length != 7) {
			return result;
		}
		result = Car.CarAcceptability.valueOf(fields[6]);
		return result;
	}
}
