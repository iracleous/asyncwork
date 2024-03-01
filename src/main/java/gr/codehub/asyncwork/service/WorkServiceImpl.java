package gr.codehub.asyncwork.service;

import gr.codehub.asyncwork.model.Person;
import gr.codehub.asyncwork.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@EnableAsync
@AllArgsConstructor
public class WorkServiceImpl implements  WorkService{

    private final EmployeeRepository personRepository;
    @Override
    @Async
    public CompletableFuture<Person> getPersonAsync(long personId) {
        // Simulating a time-consuming operation
        try {
            Thread.sleep(1000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.failedFuture(e);
        }
        Person person =personRepository.findById(personId).get();
        return CompletableFuture.completedFuture(person);
    }

    @Override
    public Person getPerson(long personId) {
        try {
            Thread.sleep(1000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
        Person person =personRepository.findById(personId).get();
        return person;
    }

    @Async
    @Override
    public Future<Person> getPersonTask(long personId) {
        // Simulating a time-consuming operation
        try {
            Thread.sleep(1000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
        Person person =personRepository.findById(personId).get();
        return CompletableFuture.completedFuture(person);
    }
}