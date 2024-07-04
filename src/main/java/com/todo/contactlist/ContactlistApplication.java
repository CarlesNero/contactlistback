package com.todo.contactlist;

import com.todo.contactlist.entity.Contact;
import com.todo.contactlist.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistApplication {

	private final ContactRepository contactRepository;

	public ContactlistApplication(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactlistApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(){
//		return args -> {
//            List<Contact> contacts = Arrays.asList(
//                    new Contact("Carlos", "carlos@gmail.com", "123456789", LocalDateTime.now()),
//                    new Contact("Pepe", "Pepe@gmail.com", "987654321", LocalDateTime.now()),
//                    new Contact("Laia", "Laia@gmail.com", "123789456", LocalDateTime.now()),
//                    new Contact("Juan", "Juan@gmail.com", "456789123", LocalDateTime.now()),
//                    new Contact("María", "María@gmail.com", "321456987", LocalDateTime.now())
//            );
//            contactRepository.saveAll(contacts);
//        };


//	}
}
