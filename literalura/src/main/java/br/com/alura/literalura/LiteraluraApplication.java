package br.com.alura.literalura;

import br.com.alura.literalura.principal.Principal;
import br.com.alura.literalura.repository.BookRepository;
import br.com.alura.literalura.repository.PersonRepository;
import br.com.alura.literalura.services.BookService;
import br.com.alura.literalura.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BookService bookService;
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(bookService, personService);
		principal.exibeMenu();
	}
}
