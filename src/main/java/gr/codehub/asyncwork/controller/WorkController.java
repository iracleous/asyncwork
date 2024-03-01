package gr.codehub.asyncwork.controller;

import gr.codehub.asyncwork.model.Person;
import gr.codehub.asyncwork.service.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@AllArgsConstructor
public class WorkController {

    private final WorkService service;

    @GetMapping("/blocking-operation")
    public String blockingOperation() {
        long startingTime = System.currentTimeMillis();
        Person personA = service.getPerson(2);
        Person personB = service.getPerson(5);
        long endingTime = System.currentTimeMillis();
        long elapsedTime = endingTime-startingTime;
        return  elapsedTime+"";
    }

    @GetMapping("/async-operation")
    public String asyncOperation() throws ExecutionException, InterruptedException {
        long startingTime = System.currentTimeMillis();
        CompletableFuture<Person>  personA = service.getPersonAsync(2);
        CompletableFuture<Person>  personB = service.getPersonAsync(5);
        Person resultA = personA.get();
        Person resultB = personB.get();
        long endingTime = System.currentTimeMillis();
        long elapsedTime = endingTime-startingTime;
        return elapsedTime+"";
    }

    @GetMapping("/simple-async-operation")
    public String asyncOperation2() throws ExecutionException, InterruptedException {
        long startingTime = System.currentTimeMillis();
        Future<Person> personA = service.getPersonTask(2);
        Future<Person> personB = service.getPersonTask(5);
        Person resultA = personA.get();
        Person resultB = personB.get();
        long endingTime = System.currentTimeMillis();
        long elapsedTime = endingTime-startingTime;
        return  elapsedTime+"";
    }


}
