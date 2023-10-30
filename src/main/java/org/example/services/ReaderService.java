package org.example.services;

import org.example.entity.Reader;

import java.util.List;

public interface ReaderService {
    void saveReader(Reader reader);
    String updateReader(Long ReaderId, Reader newReader);
    List<Reader> getReaderByBookId(Long BookId);
    String deleteReaderById(Long ReaderId);
    void getReadersByAuthorId(Long AuthorId);
}
