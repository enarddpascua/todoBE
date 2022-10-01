package com.todoapp.todoapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todos")
    @CrossOrigin("http://localhost:3000")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @RequestMapping("/todos/{id}")
    public Todo getTodo(@PathVariable Long id){
        return todoService.getTodo(id);
    }

    @RequestMapping(method = RequestMethod.POST ,value ="/todos")
    @CrossOrigin("http://localhost:3000")
    public void createTodo(@RequestBody List<Todo> todo){
        todoService.createTodo(todo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/todos")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }

}
