package org.example;


import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.services.AuthorService;
import org.example.services.BookService;
import org.example.services.PublisherService;
import org.example.services.ReaderService;
import org.example.services.impl.AuthorServImpl;
import org.example.services.impl.BookServImpl;
import org.example.services.impl.PublisherServImpl;
import org.example.services.impl.ReaderServImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = App.getSession();
        AuthorService authorService = new AuthorServImpl();
        PublisherService publisherService = new PublisherServImpl();
        BookService bookService = new BookServImpl();
        ReaderService readerService = new ReaderServImpl();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the command: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    LocalDate authorBirthdate1 = LocalDate.of(2002, 8, 15);
                    LocalDate authorBirthdate2 = LocalDate.of(2000, 9, 20);

                    Author author1 = new Author("Alina", "A", "alinka@", authorBirthdate1, "Kyrgyzstan", Gender.FEMALE);
                    Author author2 = new Author("Adel", "Zh", "adeliia@", authorBirthdate2, "UAE", Gender.FEMALE);
                    Publisher publisher1 = new Publisher("NoName", "Bishkek");
                    Publisher publisher2 = new Publisher("SamPublisher", "Osh");
                    Reader reader = new Reader("Tunuk", 17, "tunushka@gmail.com");

                    List<Author> authors = new ArrayList<>();
                    authors.add(author1);
                    authors.add(author2);

                    List<Publisher> publishers = new ArrayList<>();
                    publishers.add(publisher1);
                    publishers.add(publisher2);

                    author1.setPublishers(publishers);
                    author2.setPublishers(publishers);
                    publisher1.setAuthors(authors);
                    publisher2.setAuthors(authors);

                    Book book1 = new Book("Becoming", "Korea", 1990, 200, Genre.ROMAN);
                    Book book2 = new Book("Interstellar", "China", 2005, 200, Genre.FANTASTIC);

                    author1.setBooks(List.of(book1, book2));
                    book1.setAuthor(author1);
                    book2.setAuthor(author1);

                    publisher1.setBooks(List.of(book1, book2));
                    book1.setPublisher(publisher1);
                    book2.setPublisher(publisher1);

                    reader.setBook(List.of(book1, book2));
                    book1.setReaders(List.of(reader));
                    book2.setReaders(List.of(reader));

                    bookService.saveBook(book1);
                }
                case 2 -> {
                    Author author1 = Author.builder().first_name("Zalkar").last_name("Mamanov").email("Z@gmail.com").date_ofBirth(LocalDate.of(2007, 5, 23)).country("Russia").gender(Gender.MALE).build();
                    authorService.updateAuthor(1L, author1);
                }
                case 3 -> {
                    System.out.println(authorService.getAuthorById(2L));
                }
                case 4 -> {
                    System.out.println(authorService.getAuthorsByPublisherId(1L));
                }
                case 5 -> {
                    System.out.println(authorService.deleteAuthorById(2L));
                }
                case 6 -> {
                    System.out.println(publisherService.getPublisherById(1L));
                }
                case 7 -> {
                    System.out.println(publisherService.getAllPublishers("ASC"));
                }
                case 8 -> {
                    Publisher publisher = Publisher.builder().name("PublisherName").address("Washington").build();
                    System.out.println(publisherService.updatePublisher(1L, publisher));
                }
                case 9 -> {
                    System.out.println(publisherService.deletePublisherByName("PublisherName"));
                }
                case 10 -> {
                    Author author = new Author("Kandy", "Isaev", "Kandy@gmail.com", LocalDate.of(2006, 9, 12), "Kyrgyzstan", Gender.MALE);
                    System.out.println(bookService.updateBookAuthor(1L, author));
                }
                case 11 -> {
                    bookService.getBookAndPublisherByBookId(1L);
                }
                case 12 -> {
                    System.out.println(bookService.deleteBookByAuthorId(1L, 2L));
                }
                case 13 -> {
                    Reader reader = new Reader("Amantur",20,"A@gmail.com");
                    System.out.println(readerService.updateReader(1L,reader));
                }
                case 14 -> {
                    System.out.println(readerService.getReaderByBookId(1L));
                }
                case 15 -> {
                    System.out.println(readerService.deleteReaderById(1L));
                }
                case 16 -> {
                    readerService.getReadersByAuthorId(1L);
                }
            }
        }
    }
}
