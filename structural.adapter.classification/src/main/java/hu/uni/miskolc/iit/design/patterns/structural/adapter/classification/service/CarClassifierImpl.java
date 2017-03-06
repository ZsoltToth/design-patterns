package hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model.Car;
import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model.Car.CarAcceptability;
import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.Utils;

public class CarClassifierImpl implements CarClassifier {

	private Classifier classifier;

	public CarClassifierImpl(Classifier classifier) {
		super();
		this.classifier = classifier;
	}

	@Override
	public CarAcceptability classify(Car car) {
		CarAcceptability result = CarAcceptability.unacc;
		try {
			double classCode = classifier.classifyInstance(convertCar2Instance(car, Car.CarAcceptability.unacc));
			if(classCode == Utils.missingValue()){
				return Car.CarAcceptability.unacc;
			}
			//unacc(1), acc(2) , good(3), vgood(4);
			if(Math.abs(CarAcceptability.unacc.ordinal() - classCode) < 0.5){
				result = Car.CarAcceptability.unacc;
			}
			if(Math.abs(CarAcceptability.acc.ordinal() - classCode) < 0.5){
				result = Car.CarAcceptability.acc;
			}
			if(Math.abs(CarAcceptability.good.ordinal() - classCode) < 0.5){
				result = Car.CarAcceptability.good;
			}
			if(Math.abs(CarAcceptability.vgood.ordinal() - classCode) < 0.5){
				result = Car.CarAcceptability.vgood;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void train(Map<Car, CarAcceptability> trainingSet) {

		Instances instances = new Instances("carTrainingSet", carAttributes(), 2000);
		for (Entry<Car, Car.CarAcceptability> entry : trainingSet.entrySet()) {
			instances.add(convertCar2Instance(entry.getKey(), entry.getValue()));
		}
		instances.setClassIndex(6);

		try {
			classifier.buildClassifier(instances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Instance convertCar2Instance(Car car, Car.CarAcceptability acceptability) {
		ArrayList<Attribute> attributes = carAttributes();
		Instance result = new SparseInstance(attributes.size());
		result.setValue(0, car.getBuyingPrice().ordinal());
		result.setValue(1, car.getMaintenancePrice().ordinal());
		result.setValue(2, car.getNumberOfDoors().ordinal());
		result.setValue(3, car.getPersonCapacity().ordinal());
		result.setValue(4, car.getLuggageBootSize().ordinal());
		result.setValue(5, car.getSafety().ordinal());
		result.setValue(6, acceptability.ordinal());
		return result;
	}

	private ArrayList<Attribute> carAttributes() {
		/*
		 * Class Values:
		 * 
		 * unacc, acc, good, vgood
		 * 
		 * Attributes:
		 * 
		 * buying: vhigh, high, med, low. maint: vhigh, high, med, low. doors:
		 * 2, 3, 4, 5more. persons: 2, 4, more. lug_boot: small, med, big.
		 * safety: low, med, high.
		 */
		Attribute buying = new Attribute("buying");
		Attribute maint = new Attribute("maint");
		Attribute doors = new Attribute("doors");
		Attribute persons = new Attribute("persons");
		Attribute lug_boot = new Attribute("lug_boot");
		Attribute safety = new Attribute("safety");
		Attribute acc = new Attribute("acc");
		

		return new ArrayList<>(Arrays.asList(buying, maint, doors, persons, lug_boot, safety, acc));

	}

}
