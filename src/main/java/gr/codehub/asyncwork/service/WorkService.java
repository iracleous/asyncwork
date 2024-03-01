package gr.codehub.asyncwork.service;

import gr.codehub.asyncwork.model.Person;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface WorkService {
    CompletableFuture<Person> getPersonAsync( long personId);
    Person getPerson(long personId);
    Future<Person> getPersonTask(long personId);
}
