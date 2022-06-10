package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.BookEntity;
import exception.ApplicationException;
import pojo.BookPojo;

public class BookDaoHibernateImpl implements BookDao {

	@Override
	public BookPojo addBook(BookPojo bookPojo) throws ApplicationException {
		// copy the contents of incomming bookPojo into a BookEntity object
		BookEntity addBookEntity = new BookEntity(bookPojo.getBookTitle(), bookPojo.getBookGenre(), bookPojo.getBookAuthor(), bookPojo.getBookCost(), bookPojo.getBookImage());
		
		// lets use hibernate apis to save the book entity object in the DB
		
		// obtain the session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		// now open a session from the session factory
		Session session = sessionFactory.openSession();
		
		// next begin a transaction
		session.beginTransaction();
		
		// now save the entity object
		session.save(addBookEntity); // hibernate creates a insert query and inserts a record

		session.flush(); // this will synch the underlying table data with the entity object
		System.out.println(addBookEntity.getId()); // just for testing to see if the auto genertaed primary key is synched into the enitty object
		
		// comit the transaction
		session.getTransaction().commit();
		
		// close the session
		session.close();
		
		bookPojo.setId(addBookEntity.getId()); // set the book id into the book pojo before returning it
		return bookPojo;
	}

	@Override
	public BookPojo updateBook(BookPojo bookPojo) throws ApplicationException {
		try {
		// copy the contents of incomming bookPojo into a BookEntity object
				BookEntity updateBookEntity = new BookEntity(bookPojo.getId(), bookPojo.getBookTitle(), bookPojo.getBookGenre(), bookPojo.getBookAuthor(), bookPojo.getBookCost(), bookPojo.getBookImage());
				
				// lets use hibernate apis to save the book entity object in the DB
				
				// obtain the session factory
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				
				// now open a session from the session factory
				Session session = sessionFactory.openSession();
				
				// next begin a transaction
				session.beginTransaction();
				
				// now update the entity object
				session.update(updateBookEntity); // hibernate creates a update query and updates the record

				session.flush();
				// comit the transaction
				session.getTransaction().commit();
				
				// close the session
				session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				return bookPojo;
	}

	@Override
	public boolean deleteBook(int bookId) throws ApplicationException {
		// obtain the session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//open a session
		Session session = sessionFactory.openSession();
		
		// begin a transaction
		session.beginTransaction();
		
		// execute the dml operation
		
		// first lets fetch the book with id  - bookId
		BookEntity fetchedBookEntity = session.get(BookEntity.class, bookId);
		// next we sedn the book entity object to be deleted to the orm framework
		session.delete(fetchedBookEntity); // here delete query is not executed by hibernate, executed only when you commit the transaction
		System.out.println("session.delete() is called....");
			
		// commit the transaction
		session.getTransaction().commit();
		System.out.println("transaction commmited.....");
		
		//close the session
		session.close();
		
		return true;
	}

	@Override
	public List<BookPojo> getAllBooks() throws ApplicationException {
		// obtain the session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//open a session
		Session session = sessionFactory.openSession();
		
		//using native queries here
//		String nativeQuery = "select * from book_details";
//		List<BookEntity> allBookEntity = session.createNativeQuery(nativeQuery,BookEntity.class).getResultList();
		
		//using hql queries
		String hqlQuery = "from BookEntity";
		List<BookEntity> allBookEntity = session.createQuery(hqlQuery, BookEntity.class).getResultList();
		
		// we have to return a collection of book pojos and not a collection of book entities
		// so lets copy the contents 
		List<BookPojo> allBookPojo = new ArrayList<BookPojo>();
		for(BookEntity fetchedBookEntity: allBookEntity) {
			BookPojo returnBookPojo = new BookPojo(fetchedBookEntity.getId(), fetchedBookEntity.getBookTitle(), fetchedBookEntity.getBookGenre(), fetchedBookEntity.getBookAuthor(),fetchedBookEntity.getBookCost(), fetchedBookEntity.getBookImage());
			allBookPojo.add(returnBookPojo);
		}
		
		session.close();
		
		return allBookPojo;
	}

	@Override
	public BookPojo getABook(int bookId) throws ApplicationException {
		// obtain the session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//open a session
		Session session = sessionFactory.openSession();
		
		// begin a transaction
		session.beginTransaction();
		
		// execute the dml operation
		
		// fetch the book with id  - bookId
		BookEntity fetchedBookEntity = session.get(BookEntity.class, bookId);
				
		// copy the data in the entity object into a pojo object
		BookPojo returnBookPojo = new BookPojo(fetchedBookEntity.getId(), fetchedBookEntity.getBookTitle(), fetchedBookEntity.getBookGenre(), fetchedBookEntity.getBookAuthor(),fetchedBookEntity.getBookCost(), fetchedBookEntity.getBookImage());
		
		session.getTransaction().commit();
		
		session.close();
				
		return returnBookPojo;
	}

}
