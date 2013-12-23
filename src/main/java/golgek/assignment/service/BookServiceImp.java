package golgek.assignment.service;

import golgek.assignment.mapper.BookSummaryMapper;
import golgek.assignment.model.Book;
import golgek.assignment.model.BookSummary;
import golgek.assignment.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;



public class BookServiceImp implements BookService{

	private BookSummaryMapper bookSummaryMapper;
	private BookRepository bookRepository;
	
	public BookServiceImp(){
		bookSummaryMapper = new BookSummaryMapper();
		bookRepository = new BookRepository();
	}
	
	@Override
	public List<BookSummary> getItems(int offset, int count) {
		
		List<Book> books = bookRepository.findAll();
		List<Book> bookSearches = new ArrayList<Book>();
		int numberOfItem = 0;
		
		if(offset==0 && count ==0){
			return bookSummaryMapper.map(books);
		}else if(count == 0){
			count = books.size();
		}
		
	
		
		for(int index=offset; index< books.size(); index++){
			
			bookSearches.add(books.get(index));			
			numberOfItem++;
			
			if(numberOfItem >= count){
				break;
			}
		}
		
		return bookSummaryMapper.map(bookSearches);

	}

	@Override
	public Book getItem(int id) {
		return bookRepository.findOne(id);
	}

}
