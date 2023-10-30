package org.example.services.impl;

import org.example.entity.Author;
import org.example.repository.AuthorRepo;
import org.example.repository.impl.AuthorRepoImpl;
import org.example.services.AuthorService;

import java.util.List;

public class AuthorServImpl implements AuthorService {
    private final AuthorRepo authorRepo = new AuthorRepoImpl();

    @Override
    public void saveAuthor(Author author) {
    authorRepo.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long AuthorId, Author newAuthor) {
        return authorRepo.updateAuthor(AuthorId, newAuthor);
    }

    @Override
    public List<Author> getAuthorById(Long AuthorId) {
        return authorRepo.getAuthorById(AuthorId);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long PublisherId) {
        return authorRepo.getAuthorsByPublisherId(PublisherId);
    }

    @Override
    public String deleteAuthorById(Long AuthorId) {
        return authorRepo.deleteAuthorById(AuthorId);
    }

    @Override
    public String assignAuthorToPublisher(Long AuthorId, Long PublisherId) {
        return authorRepo.assignAuthorToPublisher(AuthorId,PublisherId);
    }
}
