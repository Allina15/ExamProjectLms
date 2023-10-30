package org.example.services;

import org.example.entity.Author;
import org.example.entity.Book;

public interface BookService {
    void saveBook(Book book);
    String updateBookAuthor(Long BookId, Author newAuthor);
    void getBookAndPublisherByBookId(Long BookId);
    //(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын),
    String deleteBookByAuthorId(Long AuthorId, Long BookId);
}
