package com.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoapp.dao.ToDoDao;
import com.todoapp.model.ToDo;

@Service("toDoService")
@Transactional
public class ToDoService {
	@Autowired
	ToDoDao toDoDao;
	
	public ToDo toDo(ToDo toDo) {	
		return toDoDao.toDo(toDo);
	}
	
	public List<ToDo> toDoList() {
		
       return toDoDao.toDoList();
    }
	 public ToDo remove(int id) {
		 return toDoDao.remove(id);
	 }
}
