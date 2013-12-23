package golgek.assignment.repository;

import golgek.assignment.common.RequestURI;
import golgek.assignment.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
	
	private List<Book> books;
	
	public BookRepository(){
		
		//initialize book 
		books = new ArrayList<Book>();		
		
		String domain = "http://" + RequestURI.getDomain();
		
		Book book1 = new Book();
		book1.setId(10);
		book1.setImage( domain + "/api/static/10.jpg");
		book1.setTitle("The Everything Store");
		book1.setAuthor("Jeff Bezos and the Age of Amazon"); 
		book1.setPrice(19.99);
		books.add(book1);
		
		Book book2 = new Book();
		book2.setId(27);
		book2.setImage( domain + "/api/static/27.jpg");
		book2.setTitle("The 7 Habits of Highly Effective People");
		book2.setAuthor("Stephen R. Covey");
		book2.setPrice(19.25);
		books.add(book2);
		
		Book book3 = new Book();
		book3.setId(3556);
		book3.setImage(domain + "/api/static/3556.jpg");
		book3.setTitle("30 Minutes Yoga:For Better Balance and Strength in Your Life");
		book3.setAuthor("Viveka Blom Nygren");
		book3.setPrice(24.50);
		books.add(book3);
		
		Book book4 = new Book();
		book4.setId(4242);
		book4.setImage( domain + "/api/static/4242.jpg");
		book4.setTitle("25 Way to Sew Jelly Rolls, Layer Cakes & Charm Packs");
		book4.setAuthor("Brioni Greenberg");
		book4.setPrice(7.50);
		books.add(book4);
		
		Book book5 = new Book();
		book5.setId(5051);
		book5.setImage(domain + "/api/static/5051.jpg");
		book5.setTitle("The Rough Guide to Guitar");
		book5.setAuthor("Dave Hunter");
		book5.setPrice(12.99);
		books.add(book5);
		
		Book book6 = new Book();
		book6.setId(5059);
		book6.setImage(domain + "/api/static/5059.jpg");
		book6.setTitle("Artchitecture for Children");
		book6.setAuthor("Sarah Scott");
		book6.setPrice(15.00);
		books.add(book6);
		
		Book book7 = new Book();
		book7.setId(6001);
		book7.setImage(domain + "/api/static/6001.jpg");
		book7.setTitle("The Hidden Europe:What Eastern Europeans Can Teach Us");
		book7.setAuthor("Francis Tapon");
		book7.setPrice(17.25);
		books.add(book7);
		
		Book book8 = new Book();
		book8.setId(8221);
		book8.setImage( domain + "/api/static/8221.jpg");
		book8.setTitle("Off-Camera Flash Techniques for Digital Photographers");
		book8.setAuthor("Neil van Nekerk");
		book8.setPrice(23.00);
		books.add(book8);
		
		Book book9 = new Book();
		book9.setId(8589);
		book9.setImage( domain + "/api/static/8589.jpg");
		book9.setTitle("The Iron Traitor");
		book9.setAuthor("Julie Kagawa");
		book9.setPrice(9.99);
		books.add(book9);
		
		Book book10 = new Book();
		book10.setId(9009);
		book10.setImage( domain + "/api/static/9009.jpg");
		book10.setTitle("All in Day's Work");
		book10.setAuthor("Tim Bryan");
		book10.setPrice(11.50);
		books.add(book10);
	}
	
	public List<Book> findAll(){
		
		return books;
	}
	
	public Book findOne(int id){
		
		for(Book book:books){
			Book bookFound = new Book();
			
			if(book.getId()==id){
				bookFound.setId(book.getId());
				bookFound.setImage(book.getImage());
				bookFound.setTitle(book.getTitle());
				bookFound.setAuthor(book.getAuthor());
				bookFound.setPrice(book.getPrice());
				
				return bookFound;
			}
			
		}
		
		return null;
	}
	
}
