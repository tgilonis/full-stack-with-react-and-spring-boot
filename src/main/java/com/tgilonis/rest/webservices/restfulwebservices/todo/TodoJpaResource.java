package com.tgilonis.rest.webservices.restfulwebservices.todo;

import com.tgilonis.rest.webservices.restfulwebservices.todo.services.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/*
    Adhere to RESTApi best practices for Response statuses
    200 - Success
    201 - Created
    400 - Bad request
    401 - Unauthorized
    404 - Resource not found
    500 - Server Error
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaResource
{
    @Autowired
    private TodoHardCodedService todoService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping(path = "/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
        return todoJpaRepository.findByUsername(username);
        //return todoService.findAll();
    }

    @DeleteMapping(path = "/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id)
    {
        todoJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        /*Todo todo = todoService.deleteById(id);
        if(todo!=null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();*/
    }

    @GetMapping(path = "/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id)
    {
        return todoJpaRepository.findById(id).get();
        // return todoService.findById(id);
    }

    @PutMapping(path = "/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo)
    {
        todo.setUsername(username);
        Todo todoUpdated = todoJpaRepository.save(todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping(path="/jpa/users/{username}/todos/")
    public ResponseEntity<URI> createTodo(@PathVariable String username, @RequestBody Todo todo) {

        todo.setUsername(username);

        Todo createdTodo = todoJpaRepository.save(todo);
        // Location of created resource to be returned
        // Get current resource URL
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
