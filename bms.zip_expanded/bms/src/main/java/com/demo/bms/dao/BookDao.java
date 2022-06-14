package com.demo.bms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bms.entity.BookEntity;

// by extending JpaRepository of spring data jpa, spring data jpa will take 
// care of the hibernate jpa implementation of the dao interface
// we need not provide an implementation class for the dao interface here


//@Component
//stereotype annotations  - @RestController, @Service, @Repository

@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer> {

}
