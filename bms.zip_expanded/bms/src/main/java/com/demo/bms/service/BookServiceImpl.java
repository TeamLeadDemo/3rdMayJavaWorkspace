package com.demo.bms.service;

import java.util.List;

import com.demo.bms.dao.BookDao;
import com.demo.bms.exception.ApplicationException;
import com.demo.bms.pojo.BookPojo;

public class BookServiceImpl implements BookService{
   
	BookDao bookDao;
	
	public BookServiceImpl() {
		//this.bookDao = new BookDaoImpl();
		//this.bookDao = new BookDaoImpl();
		
		// changing the implementation class to BookDaoHibernateImpl
		//this.bookDao = new BookDaoHibernateImpl();
	}
  
	@Override
	public BookPojo addBook(BookPojo bookPojo) throws ApplicationException {
		//logger.info("Entered addBook() in service.");
		//BookPojo returnBookPojo = this.bookDao.addBook(bookPojo);
		//logger.info("Exited addBook() in service.");
		return bookPojo;
	}

	@Override
	public BookPojo updateBook(BookPojo bookPojo) throws ApplicationException {
		//logger.info("Entered updateBook() in service.");
		//BookPojo returnBookPojo = this.bookDao.updateBook(bookPojo);
		//logger.info("Exited updateBook() in service.");
		return bookPojo;
	}

	@Override
	public boolean deleteBook(int bookId) throws ApplicationException {
		//logger.info("Entered deleteBook() in service.");
		//boolean returnFlag = this.bookDao.deleteBook(bookId);
		//logger.info("Exited deleteBook() in service.");
		return true;
	}

	@Override
	public List<BookPojo> getAllBooks() throws ApplicationException {
		//logger.info("Entered getAllBooks() in service.");
		//List<BookPojo> allBooks = this.bookDao.getAllBooks();
		//logger.info("Exited getAllBooks() in service.");
		return null;
	}

	@Override
	public BookPojo getABook(int bookId) throws ApplicationException {
		//logger.info("Entered getABook() in service.");
		//BookPojo returnBookPojo = this.bookDao.getABook(bookId);
		//logger.info("Exited getABook() in service.");
		return null;
	}
}
