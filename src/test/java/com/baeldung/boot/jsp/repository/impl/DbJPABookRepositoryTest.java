package com.baeldung.boot.jsp.repository.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.boot.jsp.repository.BookRepository;
import com.baeldung.boot.jsp.repository.model.BookData;

@SpringBootTest
class DbJPABookRepositoryTest {

	@Autowired
	BookRepository bookRepo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
//		bookRepo = new DbJPABookRepository();
	}

	@AfterEach
	void tearDown() throws Exception {
	//	bookRepo = null;
	}

	@Test
	void testFindAll() {
		assertEquals(5, bookRepo.findAll().size());
	}

	@Test
	void testFindById() {
		assertEquals("Twilight", bookRepo.findById("9780316038379").get().getName());
	}

	@Test
	void testAdd() {
		BookData myBook = new BookData("123", "hola", "autor");
		BookData storedBook = bookRepo.add(myBook);
		assertEquals("autor", storedBook.getAuthor());
		
	}

}
