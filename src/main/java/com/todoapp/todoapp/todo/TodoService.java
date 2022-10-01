package com.todoapp.todoapp.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void createTodo(List<Todo> todo) {
        todoRepository.deleteAll();
        todoRepository.saveAll(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }



}
