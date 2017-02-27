package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model;

import java.io.File;
import java.util.List;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public abstract class AbstractScientifiPaperBuilder implements ScientificPaperBuilder {

	public final ScientificPaper build(String filePath) throws NotExpectedFormatException{
		return build(new File(filePath));
	}

	public final ScientificPaper build(File paper) throws NotExpectedFormatException{
		checkFileFormat(paper);
		String title = extractTitle(paper);
		String paperAbstract = extractAbstract(paper);
		List<Author> authors = extractAuthors(paper);
		return new ScientificPaper(title, paperAbstract, authors, paper);
	}
	
	protected abstract void checkFileFormat(File paper) throws NotExpectedFormatException;
	protected abstract String extractTitle(File paper);
	protected abstract String extractAbstract(File paper);
	protected abstract List<Author> extractAuthors(File paper);
}
