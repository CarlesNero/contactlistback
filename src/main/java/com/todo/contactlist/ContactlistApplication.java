package com.todo.contactlist;

import com.todo.contactlist.entity.Book;
import com.todo.contactlist.entity.Contact;
import com.todo.contactlist.repository.ContactRepository;
import com.todo.contactlist.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistApplication {

	private final ContactRepository contactRepository;
	private final BookRepository bookRepository;

	public ContactlistApplication(ContactRepository contactRepository, BookRepository bookRepository) {
		this.contactRepository = contactRepository;
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactlistApplication.class, args);
	}

//	@Bean
//	CommandLineRunner bookRunner() {
//		return args -> {
//			List<Book> books = Arrays.asList(
//					new Book("titulo1", "autor1", "editorial1", "ISBN0001", 1),
//					new Book("titulo2", "autor2", "editorial2", "ISBN0002", 2)
//			);
//			bookRepository.saveAll(books);
//		};
//	}


}
