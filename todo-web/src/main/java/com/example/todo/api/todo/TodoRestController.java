package com.example.todo.api.todo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.todo.domain.model.Todo;
import com.example.todo.domain.service.todo.TodoService;

@RestController
@RequestMapping("todos")
public class TodoRestController {

    @Inject
    TodoService todoService;
    @Inject
    Mapper beanMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResource> getTodos() {
        Collection<Todo> todos = todoService.findAll();
        List<TodoResource> todoResources = new ArrayList<>();
        for (Todo todo : todos) {
            todoResources.add(beanMapper.map(todo, TodoResource.class));
        }
        return todoResources;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    // public TodoResource postTodos(@RequestBody @Validated TodoResource todoResource) {
    public ResponseEntity<TodoResource> postTodos(@RequestBody @Validated TodoResource todoResource, UriComponentsBuilder uriBuilder) {
        Todo createdTodo = todoService.create(beanMapper.map(todoResource, Todo.class));
        TodoResource createdTodoResponse = beanMapper.map(createdTodo, TodoResource.class);
        // return createdTodoResponse;
        
        URI createdUri = uriBuilder.path("/todos/{todoId}")
                .buildAndExpand(createdTodoResponse.getTodoId()).toUri();
        return ResponseEntity.created(createdUri).body(createdTodoResponse);
    }
    
    @RequestMapping(value="{todoId}", method = { RequestMethod.GET,
    											 RequestMethod.HEAD })
    @ResponseStatus(HttpStatus.OK)
    public TodoResource getTodo(@PathVariable("todoId") String todoId) {
        Todo todo = todoService.findOne(todoId);
        TodoResource todoResource = beanMapper.map(todo, TodoResource.class);
        return todoResource;
    }

    @RequestMapping(value="{todoId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public TodoResource putTodo(@PathVariable("todoId") String todoId) {
        Todo finishedTodo = todoService.finish(todoId);
        TodoResource finishedTodoResource = beanMapper.map(finishedTodo, TodoResource.class);
        return finishedTodoResource;
    }

    @RequestMapping(value="{todoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable("todoId") String todoId) {
        todoService.delete(todoId);
    }

    @RequestMapping(value="{todoId}", method = RequestMethod.OPTIONS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> optionsTodo(
        @PathVariable("todoId") String todoId) {

    	todoService.findOne(todoId);

        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.HEAD, HttpMethod.PUT,
                        HttpMethod.DELETE, HttpMethod.OPTIONS).build();
    }
    
}
