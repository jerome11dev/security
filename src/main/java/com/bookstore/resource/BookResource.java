package com.bookstore.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Book addBookPost(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@RequestMapping(value="/bookList",method=RequestMethod.GET)
	public List<Book> getBookList() {
		return bookService.findAll();
	}
	
	@RequestMapping("/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		Book book =bookService.findOne(id);
		return book;
	}
}
