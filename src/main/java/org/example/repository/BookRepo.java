package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;

public interface BookRepo {
    void saveBook(Book book);
    String updateBookAuthor(Long BookId, Author newAuthor);
    void getBookAndPublisherByBookId(Long BookId);
    //(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын),
    String deleteBookByAuthorId(Long AuthorId, Long BookId);
}
