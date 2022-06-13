package com.tugas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "publisher", nullable = false)
	private String publisher;
	
	@Column(name = "author", nullable = false)
	private String author ;
	
	@Column(name = "years", nullable = false)
	private String years ;

}
