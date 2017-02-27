package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.AbstractScientifiPaperBuilder;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.ScientificPaper;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.builder.latex.ScientificPaperLatexBuilder;
import hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model.exceptions.NotExpectedFormatException;

public class ScientificPaperLatexBuilderTest {

	@Test
	public void test() throws NotExpectedFormatException {
		AbstractScientifiPaperBuilder builder = new ScientificPaperLatexBuilder();
		ScientificPaper paper = builder.build(new File("dummy.tex"));
		System.out.println(paper.toString());
	}

}
