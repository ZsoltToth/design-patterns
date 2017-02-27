package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.builder.word;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.Author;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.AbstractScientifiPaperBuilder;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public class ScientificPaperWordBuilder extends AbstractScientifiPaperBuilder {

	private static Set<String> expectedExtensions;
	
	static {
		expectedExtensions = new HashSet<String>(Arrays.asList("doc", "docx"));
	}
	
	@Override
	protected void checkFileFormat(File paper) throws NotExpectedFormatException {
		// TODO Auto-generated method stub
		if(!expectedExtensions.contains(paper.getName().split(".")[1])){
			throw new NotExpectedFormatException();
		}
	}

	@Override
	protected String extractTitle(File paper) {
		// TODO Auto-generated method stub
		return "Word Title";
	}

	@Override
	protected String extractAbstract(File paper) {
		// TODO Auto-generated method stub
		return "abstract word";
	}

	@Override
	protected List<Author> extractAuthors(File paper) {
		// TODO Auto-generated method stub
		return Arrays.asList(new Author("Author 1", "mail 1", "affiliation 1"));
	}

}
