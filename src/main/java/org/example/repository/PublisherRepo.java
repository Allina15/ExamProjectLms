package org.example.repository;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherRepo {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long PublisherId);
    List<Publisher> getAllPublishers(String ascOrDesc);
    //(аты боюнча сорттоп чыгаруу),
    String updatePublisher(Long PublisherId, Publisher newPublisher);
    String deletePublisherByName(String PublisherName);
    //(издательствону очургондо, ага тиешелуу китептер жана авторлор  очпошу керек)
}
