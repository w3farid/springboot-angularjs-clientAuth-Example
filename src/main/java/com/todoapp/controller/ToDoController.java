package com.todoapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.model.ToDo;
import com.todoapp.service.ToDoService;

@RestController
public class ToDoController {
	@Autowired
	ToDoService toDoService;

	@PostMapping("/todo")
	public ToDo toDo(@RequestBody ToDo toDo) {
		
		toDo.setCreatedDate(new Date());
		ToDo entity = toDoService.toDo(toDo);
		return entity;
	}
	
	@GetMapping("/show-todo")
    public List<ToDo> user(HttpServletRequest request) {
       return toDoService.toDoList();
    }
	
	@GetMapping("/delete/{id}")
    public ToDo remove(@PathVariable int id) {
       return toDoService.remove(id);
    }
}
