package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.repository.ReaderRepo;

import java.util.ArrayList;
import java.util.List;

public class ReaderRepoImpl implements ReaderRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();
    @Override
    public void saveReader(Reader reader) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String updateReader(Long ReaderId, Reader newReader) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, ReaderId);
        reader.setName(newReader.getName());
        reader.setEmail(newReader.getEmail());
        reader.setAge(newReader.getAge());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Reader updated "+newReader;
    }

    @Override
    public List<Reader> getReaderByBookId(Long BookId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, BookId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book.getReaders();
    }

    @Override
    public String deleteReaderById(Long ReaderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, ReaderId);
        for (Book b: reader.getBook()) {
            b.getReaders().clear();
        }
        reader.getBook().clear();
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Reader deleted";
    }

    @Override
    public void getReadersByAuthorId(Long AuthorId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, AuthorId);
        List<Book>books = author.getBooks();
        for (Book b:books) {
            System.out.println(b.getReaders());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
