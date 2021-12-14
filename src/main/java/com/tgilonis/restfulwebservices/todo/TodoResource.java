package com.tgilonis.restfulwebservices.todo;

import com.tgilonis.restfulwebservices.todo.services.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource
{
    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
        return todoService.findAll();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id)
    {
        Todo todo = todoService.deleteById(id);
        if(todo!=null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id)
    {
        return todoService.findById(id);
    }

    /*@PutMapping(path = "/users/todos/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable long id)
    {
        Todo todo = todoService.updateById(id);
        if(todo!=null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }*/

}
