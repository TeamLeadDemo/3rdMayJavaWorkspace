package com.demo.bms.service;

import java.util.List;

import com.demo.bms.exception.ApplicationException;
import com.demo.bms.pojo.BookPojo;

public interface BookService {
	BookPojo addBook(BookPojo bookPojo) throws ApplicationException;
	
	BookPojo updateBook(BookPojo bookPojo) throws ApplicationException;
	
	boolean deleteBook(int bookId) throws ApplicationException;
	
	List<BookPojo> getAllBooks() throws ApplicationException;
	
	BookPojo getABook(int bookId) throws ApplicationException;
}
