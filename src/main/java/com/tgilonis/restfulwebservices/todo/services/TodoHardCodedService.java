package com.tgilonis.restfulwebservices.todo.services;

import com.tgilonis.restfulwebservices.todo.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService
{
    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;


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
}
