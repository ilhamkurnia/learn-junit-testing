package com.tugas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	Optional<Book> findByTitle(String title);

}
