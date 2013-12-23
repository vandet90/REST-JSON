package golgek.assignment.mapper;

import golgek.assignment.common.RequestURI;
import golgek.assignment.model.Book;
import golgek.assignment.model.BookSummary;

import java.util.ArrayList;
import java.util.List;

public class BookSummaryMapper {

	public List<BookSummary> map(List<Book> books){
		
		List<BookSummary> bookSummaries = new ArrayList<BookSummary>();
		
		for(Book book:books){
			
			BookSummary bookSummary = new BookSummary();
			bookSummary.setId(book.getId());
			
			String link = RequestURI.PATH + book.getId();			
			bookSummary.setLink(link);
			
			bookSummary.setTitle(book.getTitle());
			
			bookSummaries.add(bookSummary);
		}
		
		return bookSummaries;
	}
	
}

