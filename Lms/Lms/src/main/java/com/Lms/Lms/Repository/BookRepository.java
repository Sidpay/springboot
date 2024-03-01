package com.Lms.Lms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lms.Lms.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
