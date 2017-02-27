package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model;

import java.io.File;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public interface ScientificPaperBuilder {
	ScientificPaper build(String filePath) throws NotExpectedFormatException;

	ScientificPaper build(File paper) throws NotExpectedFormatException;
}
