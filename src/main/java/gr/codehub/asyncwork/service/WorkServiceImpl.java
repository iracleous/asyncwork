package gr.codehub.asyncwork.service;

import gr.codehub.asyncwork.model.Person;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class WorkServiceImpl implements  WorkService{

    @Override
    @Async
    public CompletableFuture<Person> getPersonAsync(int personId) {
        // Simulating a time-consuming operation
        try {
            Thread.sleep(1000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.failedFuture(e);
        }
        Person person = new Person();
        person.setId(personId);
        return CompletableFuture.completedFuture(person);
    }

    @Override
    public Person getPerson(int personId) {
        try {
            Thread.sleep(1000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
        Person person = new Person();
        person.setId(personId);
        return person;
    }
}