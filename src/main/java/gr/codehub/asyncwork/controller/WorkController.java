package gr.codehub.asyncwork.controller;

import gr.codehub.asyncwork.model.Person;
import gr.codehub.asyncwork.service.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class WorkController {

    private final WorkService workService;

    @GetMapping("/async-operation")
    public CompletableFuture<Person> asyncOperation() {
        // Call the asynchronous method of the service
        return workService.asyncMethod(7);
    }
}
