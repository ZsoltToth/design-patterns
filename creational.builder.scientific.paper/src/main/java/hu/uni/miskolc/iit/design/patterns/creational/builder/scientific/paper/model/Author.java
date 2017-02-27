package hu.uni.miskolc.iit.design.patterns.creational.builder.scientific.paper.model;

public class Author {

	private String name;
	private String email;
	private String affiliation;

	public Author(String name, String email, String affiliation) {
		super();
		this.name = name;
		this.email = email;
		this.affiliation = affiliation;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAffiliation() {
		return affiliation;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", affiliation=" + affiliation + "]";
	}

}
