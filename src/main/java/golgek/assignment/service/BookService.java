package golgek.assignment.service;

import golgek.assignment.model.Book;
import golgek.assignment.model.BookSummary;

import java.util.List;

public interface BookService {

	List<BookSummary> getItems(int offset, int count);
	Book getItem(int id);
	
}
