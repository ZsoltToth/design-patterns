package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model;

import java.io.File;
import java.util.Collection;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public class CompositeScientificPaperBuilder implements ScientificPaperBuilder {

	private Collection<AbstractScientifiPaperBuilder> builders;

	public CompositeScientificPaperBuilder(Collection<AbstractScientifiPaperBuilder> builders) {
		super();
		this.builders = builders;
	}

	public ScientificPaper build(String filePath) throws NotExpectedFormatException {
		for (ScientificPaperBuilder builder : builders) {
			try {
				ScientificPaper paper = builder.build(filePath);
				return paper;
			} catch (NotExpectedFormatException ex) {

			}
		}
		throw new NotExpectedFormatException();
	}

	public ScientificPaper build(File paper) throws NotExpectedFormatException {
		for (ScientificPaperBuilder builder : builders) {
			try {
				ScientificPaper result = builder.build(paper);
				return result;
			} catch (NotExpectedFormatException ex) {

			}
		}
		throw new NotExpectedFormatException();
	}

}
