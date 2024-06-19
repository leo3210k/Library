package com.example.library.config;

import com.example.library.models.Book;
import com.example.library.models.Loan;
import com.example.library.models.Session;
import com.example.library.models.User;
import com.example.library.repositories.UserRepository;
import com.example.library.repositories.LoanRepository;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "Rua Baiano", "86994778760");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "Rua Pinheiro", "86994778760");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Loan l1 = new Loan(null, Date.from(Instant.now()), Date.from(Instant.now()), u1);
        Loan l2 = new Loan(null, Date.from(Instant.now()), Date.from(Instant.now()), u2);

        loanRepository.saveAll(Arrays.asList(l1, l2));

        Session s1 = new Session(null, "Terror/Mistério", "C1");
        Session s2 = new Session(null, "Fantasia", "B4");

        sessionRepository.saveAll(Arrays.asList(s1, s2));

        Book b1 = new Book(null, "O Iluminado", "Stephen King", s1);
        Book b2 = new Book(null, "Harry Potter: O prisioneiro de Azkaban", "J.K.Rowlling", s2);

        bookRepository.saveAll(Arrays.asList(b1, b2));

        l1.getBooks().add(b2);
        l2.getBooks().add(b1);
        l2.getBooks().add(b2);

        loanRepository.saveAll(Arrays.asList(l1, l2));
    }
}
