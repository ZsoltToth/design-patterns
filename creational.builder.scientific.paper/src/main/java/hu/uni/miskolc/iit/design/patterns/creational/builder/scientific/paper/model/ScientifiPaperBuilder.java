package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model;

import java.io.File;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public abstract class ScientifiPaperBuilder {

	public abstract ScientificPaper build(String filePath) throws NotExpectedFormatException;

	public abstract ScientificPaper build(File paper) throws NotExpectedFormatException;
}
