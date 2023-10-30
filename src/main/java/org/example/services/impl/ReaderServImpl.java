package org.example.services.impl;

import org.example.entity.Reader;
import org.example.repository.ReaderRepo;
import org.example.repository.impl.ReaderRepoImpl;
import org.example.services.ReaderService;

import java.util.List;

public class ReaderServImpl implements ReaderService{
    private final ReaderRepo readerRepo = new ReaderRepoImpl();

    @Override
    public void saveReader(Reader reader) {
    readerRepo.saveReader(reader);
    }

    @Override
    public String updateReader(Long ReaderId, Reader newReader) {
        return readerRepo.updateReader(ReaderId, newReader);
    }

    @Override
    public List<Reader> getReaderByBookId(Long BookId) {
        return readerRepo.getReaderByBookId(BookId);
    }

    @Override
    public String deleteReaderById(Long ReaderId) {
        return readerRepo.deleteReaderById(ReaderId);
    }

    @Override
    public void getReadersByAuthorId(Long AuthorId) {
       readerRepo.getReadersByAuthorId(AuthorId);
    }
}
