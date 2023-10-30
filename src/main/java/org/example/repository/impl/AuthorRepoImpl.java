package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Author;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepo;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepoImpl implements AuthorRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();
    @Override
    public void saveAuthor(Author author) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(author);
    entityManager.getTransaction().commit();
    entityManager.close();
    }

    @Override
    public String updateAuthor(Long AuthorId, Author newAuthor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class,AuthorId);
        author.setFirst_name(newAuthor.getFirst_name());
        author.setLast_name(newAuthor.getLast_name());
        author.setEmail(newAuthor.getEmail());
        author.setDate_ofBirth(newAuthor.getDate_ofBirth());
        author.setCountry(newAuthor.getCountry());
        author.setGender(newAuthor.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author updated "+ newAuthor;
    }

    @Override
    public List<Author> getAuthorById(Long AuthorId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Author>authors = new ArrayList<>();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, AuthorId);
        authors.add(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return authors;
    }

    @Override
    public List <Author> getAuthorsByPublisherId(Long PublisherId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, PublisherId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher.getAuthors();
    }

    @Override
    public String deleteAuthorById(Long AuthorId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, AuthorId);
        for (Publisher p : author.getPublishers()){
            p.getAuthors().remove(author);
        }
        author.getPublishers().clear();
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author was deleted";
    }

    @Override
    public String assignAuthorToPublisher(Long AuthorId, Long PublisherId) {
        return null;
    }
}
