package org.example.services.impl;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookRepo;
import org.example.repository.impl.BookRepoImpl;
import org.example.services.BookService;

public class BookServImpl implements BookService {
    private final BookRepo bookRepo = new BookRepoImpl();

    @Override
    public void saveBook(Book book) {
    bookRepo.saveBook(book);
    }

    @Override
    public String updateBookAuthor(Long BookId, Author newAuthor) {
        return bookRepo.updateBookAuthor(BookId, newAuthor);
    }

    @Override
    public void getBookAndPublisherByBookId(Long BookId) {
    bookRepo.getBookAndPublisherByBookId(BookId);
    }

    @Override
    public String deleteBookByAuthorId(Long AuthorId, Long BookId) {
        return bookRepo.deleteBookByAuthorId(AuthorId, BookId);
    }
}
