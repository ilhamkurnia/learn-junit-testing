package com.tugas;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.tugas.model.Book;
import com.tugas.repository.BookRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryTesting {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveBookTesting() {
		Book book = Book.builder()
				.isbn("081231230")
				.title("Belajar SQA")
				.publisher("Gue Jago")
				.author("Dr. ilham kurnia M.Kom")
				.years("2022")
				.build();
		bookRepository.save(book);
		Assertions.assertThat(book.getId()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(2)
	public void getBookTesting() {
		Book book = bookRepository.findById(1L).get();
		Assertions.assertThat(book.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(3)
	public void getListOfBookTesting() {
		List<Book> book = bookRepository.findAll();
		Assertions.assertThat(book.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void UpdateBookTesting() {
		Book book = bookRepository.findById(1L).get();
		book.setTitle("Belajar SQA Aja");
		Book studentUpdated = bookRepository.save(book);
		Assertions.assertThat(studentUpdated.getTitle()).isEqualTo("Belajar SQA Aja");
	}
	
	@Test
	@Order(5)
	public void getBookTitleTesting() {
		Book book = bookRepository.findByTitle("Belajar SQA Aja").get();
		Assertions.assertThat(book.getTitle()).isEqualTo("Belajar SQA Aja");
	}
	 
	@Test
	@Order(6)
	public void DeleteBookTesting() {
		Book book = bookRepository.findById(1L).get();
		bookRepository.delete(book);
		Optional<Book> bookDeleted = bookRepository.findById(1L);
		Assertions.assertThat(bookDeleted).isEmpty();
	}

}
