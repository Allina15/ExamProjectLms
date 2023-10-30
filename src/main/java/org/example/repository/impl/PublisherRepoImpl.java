package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.PublisherRepo;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepoImpl implements PublisherRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long PublisherId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id =: PublisherId", Publisher.class).setParameter("PublisherId",PublisherId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }
    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String sort = ascOrDesc.equalsIgnoreCase("ASC") ? "ASC" : "DESC";
        List<Publisher> publishers = entityManager.createQuery("select p from Publisher p order by name " + sort, Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publishers;
    }

    @Override
    public String updatePublisher(Long PublisherId, Publisher newPublisher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id =: PublisherId", Publisher.class).setParameter("PublisherId",PublisherId).getSingleResult();
        publisher.setName(newPublisher.getName());
        publisher.setAddress(newPublisher.getAddress());
        entityManager.merge(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Publisher updated: "+newPublisher;
    }

    @Override
    public String deletePublisherByName(String PublisherName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.name =: PublisherName", Publisher.class).setParameter("PublisherName",PublisherName).getSingleResult();
        for (Author a : publisher.getAuthors()) {
            a.getPublishers().remove(publisher);
        }
        publisher.getAuthors().clear();
        for (Book book : publisher.getBooks()) {
            book.setPublisher(null);
        }
        publisher.getBooks().clear();
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Publisher deleted";
    }
}
