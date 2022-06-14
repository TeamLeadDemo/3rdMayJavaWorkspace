package com.demo.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bms.exception.ApplicationException;
import com.demo.bms.pojo.BookPojo;
import com.demo.bms.service.BookService;

@CrossOrigin // to enable cors
@RestController
@RequestMapping("api")
public class BookController {
	
	// throws ApplicationException is incorrect here, have to handle the exceptions gracefully
	// this can be done using GlobalExceptionHAndler - will be covered tomorrow
	
	@Autowired
	BookService bookService;
	// create the rest methods for the rest enpoints
	
	// http://localhost:5555/api/books
	@GetMapping("books")
	public List<BookPojo> getAllBooks() throws ApplicationException{
		return bookService.getAllBooks();
	}
	
	// http://localhost:5555/api/books/2
	@GetMapping("books/{bid}")
	public BookPojo getABook(@PathVariable("bid") int bookId) throws ApplicationException {
		return bookService.getABook(bookId);
	}
	
	//http://localhost:5555/api/books/2
	@DeleteMapping("books/{bid}")
	public boolean deleteBook(@PathVariable("bid") int bookId) throws ApplicationException {
		return bookService.deleteBook(bookId);
	}
	
	// http://localhost:5555/api/books
	@PostMapping("books")
	public BookPojo addBook(@RequestBody BookPojo bookPojo) throws ApplicationException {
		return bookService.addBook(bookPojo);
	}

	// http://localhost:5555/api/books
	@PutMapping("books")
	public BookPojo updateBook(@RequestBody BookPojo bookPojo) throws ApplicationException {
		return bookService.updateBook(bookPojo);
	}
	
}
