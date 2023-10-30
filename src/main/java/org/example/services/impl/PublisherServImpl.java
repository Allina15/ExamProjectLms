package org.example.services.impl;

import org.example.entity.Publisher;
import org.example.repository.PublisherRepo;
import org.example.repository.impl.PublisherRepoImpl;
import org.example.services.PublisherService;

import java.util.List;

public class PublisherServImpl implements PublisherService {
    private final PublisherRepo publisherRepo = new PublisherRepoImpl();

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepo.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long PublisherId) {
        return publisherRepo.getPublisherById(PublisherId);
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        return publisherRepo.getAllPublishers(ascOrDesc);
    }

    @Override
    public String updatePublisher(Long PublisherId, Publisher newPublisher) {
        return publisherRepo.updatePublisher(PublisherId, newPublisher);
    }

    @Override
    public String deletePublisherByName(String PublisherName) {
        return publisherRepo.deletePublisherByName(PublisherName);
    }
}
