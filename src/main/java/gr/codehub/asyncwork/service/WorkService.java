package gr.codehub.asyncwork.service;

import gr.codehub.asyncwork.model.Person;

import java.util.concurrent.CompletableFuture;

public interface WorkService {
    CompletableFuture<Person> getPersonAsync( int personId);
    Person getPerson(int personId);
}
