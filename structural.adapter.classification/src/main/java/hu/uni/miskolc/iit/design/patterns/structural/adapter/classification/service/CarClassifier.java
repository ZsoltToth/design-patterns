package hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.service;

import hu.uni.miskolc.iit.design.patterns.structural.adapter.classification.model.Car;

public interface CarClassifier {

	Car.CarAcceptability classify(Car car);
}
