package org.example.repository;

import org.example.entity.Author;

import java.util.List;

public interface AuthorRepo {
    void saveAuthor(Author author);
    String updateAuthor(Long AuthorId, Author newAuthor);
    List<Author> getAuthorById(Long AuthorId);
    List<Author> getAuthorsByPublisherId(Long PublisherId);
    //(тиешелуу издательствонун авторлорун чыгарып беруу),
    String deleteAuthorById(Long AuthorId);
    //(автор очкондо, авторго тиешелуу издательство очпошу керек, китептер очуш керек),
    String assignAuthorToPublisher(Long AuthorId, Long PublisherId);
    //(авторду издательствого кошуп коюу(назначить)).
}
