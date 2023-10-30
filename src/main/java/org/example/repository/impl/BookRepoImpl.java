package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookRepo;

import java.util.List;

public class BookRepoImpl implements BookRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();
    @Override
    public void saveBook(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String updateBookAuthor(Long BookId, Author newAuthor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, BookId);
        book.setAuthor(newAuthor);
        entityManager.merge(newAuthor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author updated " + newAuthor;
    }

    @Override
    public void getBookAndPublisherByBookId(Long BookId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Book book = entityManager.find(Book.class, BookId);
    entityManager.getTransaction().commit();
    entityManager.close();
        System.out.println(book.getName()+" "+book.getPublisher());
    }

    @Override
    public String deleteBookByAuthorId(Long AuthorId, Long BookId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, AuthorId);
        List <Book> books = author.getBooks();
        Book book = entityManager.find(Book.class, BookId);
        books.remove(book);
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Book deleted";
    }
}
