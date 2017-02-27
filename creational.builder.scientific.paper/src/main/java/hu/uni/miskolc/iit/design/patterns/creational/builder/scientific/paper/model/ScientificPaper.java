package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model;

import java.io.File;
import java.util.List;

public class ScientificPaper {

	private String title;
	private String paperAbstract;
	private List<Author> authors;
	private File paper;

	protected ScientificPaper(String title, String paperAbstract, List<Author> authors, File paper) {
		super();
		this.title = title;
		this.paperAbstract = paperAbstract;
		this.authors = authors;
		this.paper = paper;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPaperAbstract() {
		return paperAbstract;
	}

	public void setPaperAbstract(String paperAbstract) {
		this.paperAbstract = paperAbstract;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public File getPaper() {
		return paper;
	}

	public void setPaper(File paper) {
		this.paper = paper;
	}

}
