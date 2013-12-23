package golgek.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

	private Integer id;
	private String image;
	private String title;
	private String author;
	private double price;
	
	public Book(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", image=" + image + ", title=" + title
				+ ", author=" + author + ", price=" + price + "]";
	}
	
	
	
	
}
