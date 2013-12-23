package golgek.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookSummary {

	private int id;
	private String link;
	private String title;
	
	public BookSummary(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
