package com.cliveford.book.webapp.bootstrap;

import com.cliveford.book.webapp.model.Author;
import com.cliveford.book.webapp.model.Book;
import com.cliveford.book.webapp.repositories.AuthorRepository;
import com.cliveford.book.webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author george = new Author("George", "Orwell");
        Book farm = new Book("Animal Farm", "123123");
        george.getBooks().add(farm);
        farm.getAuthors().add(george);

        authorRepository.save(george);
        bookRepository.save(farm);

        Author douglas = new Author("Douglas", "Adams");
        Book hitch = new Book("Hitch hikers guide to the galaxy", "888999");
        douglas.getBooks().add(hitch);
        hitch.getAuthors().add(douglas);

        authorRepository.save(douglas);
        bookRepository.save(hitch);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
