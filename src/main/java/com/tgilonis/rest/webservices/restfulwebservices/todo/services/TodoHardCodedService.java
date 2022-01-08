package com.tgilonis.rest.webservices.restfulwebservices.todo.services;

import com.tgilonis.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService
{
    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;


    static
    {
        todos.add(new Todo(++idCounter, "TestTodos", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "TestTodos", "Learn about Microservices", new Date(), false));
        todos.add(new Todo(++idCounter, "TestTodos", "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll()
    {
        return todos;
    }

    public Todo deleteById(long id)
    {
        Todo todo = findById(id);
        if(todo == null)
        {
            return null;
        }
        // if successful, return the todo
        if(todos.remove(todo))
        {
            return todo;
        }
        return null;
    }

    public Todo findById(long id)
    {
        for (Todo todo : todos)
        {
            if (todo.getId() == id)
            {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo) {
        // if there is no pre-existing todo, create a new one
        if(todo.getId()==-1 || todo.getId()==0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
