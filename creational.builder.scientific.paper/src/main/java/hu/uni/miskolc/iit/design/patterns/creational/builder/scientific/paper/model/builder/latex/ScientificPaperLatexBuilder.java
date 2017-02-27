package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.builder.latex;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.Author;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.AbstractScientifiPaperBuilder;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public class ScientificPaperLatexBuilder extends AbstractScientifiPaperBuilder {

	private static Set<String> expectedExtensions;

	static {
		expectedExtensions = new HashSet<String>(Arrays.asList("tex"));
	}

	@Override
	protected void checkFileFormat(File paper) throws NotExpectedFormatException {
		// TODO Auto-generated method stub
		for(String suffix : expectedExtensions){
			if(paper.getName().endsWith(suffix)){
				return;
			}
		}
		throw new NotExpectedFormatException();
	}

	@Override
	protected String extractTitle(File paper) {
		// Extract title
		// long implementation
		String title = "Dummy Latex Title";
		return title;
	}

	@Override
	protected String extractAbstract(File paper) {
		// Extract abstract
		// implmentation
		String paperAbstract = "Latex Abstract";
		// TODO Auto-generated method stub
		return paperAbstract;
	}

	@Override
	protected List<Author> extractAuthors(File paper) {
		// Extract authors
		List<Author> authors = Arrays.asList(new Author("Author 1", "mail 1", "affiliation 1"),
				new Author("Author 2", "mail 2", "affiliation 2"), new Author("Author 3", "mail 3", "affiliation 3"));
		return authors;
	}

}
