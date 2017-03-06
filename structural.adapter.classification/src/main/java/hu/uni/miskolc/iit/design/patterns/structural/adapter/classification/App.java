package hu.uni.miskolc.iit.design.patterns.structural.adapter.classification;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model.Car;
import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model.Car.CarAcceptability;
import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.service.CarClassifier;
import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.service.CarClassifierImpl;
import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.service.CarReader;
import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		CarReader reader = new CarReader();
		String trainingSetInputFilePath = "resources/car/car.data";
		File trainingSetInput = new File(trainingSetInputFilePath);
		Map<Car, Car.CarAcceptability> trainingSet = reader.readTrainingSet(trainingSetInput);
		System.out.println(trainingSet.size());
		
		CarClassifier classifier = new CarClassifierImpl(new MultilayerPerceptron());
		
		classifier.train(trainingSet);
		System.out.println("trained -------------");
		Car car00 = new Car(Car.BuyingPrice.low, Car.MaintenancePrice.low, Car.NumberOfDoors.fiveOrMore, Car.PersonCapacity.four, Car.LuggageBootSize.big, Car.Safety.high);
		System.out.println("--> "+classifier.classify(car00));
	}

}
