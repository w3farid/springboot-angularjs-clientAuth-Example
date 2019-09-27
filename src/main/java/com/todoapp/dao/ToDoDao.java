package com.todoapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.todoapp.model.ToDo;

@Repository
public class ToDoDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public ToDo toDo(ToDo toDo) {	
		Session s = null;
		try {
			s = sessionFactory.getCurrentSession();
			
			s.save(toDo);
			s.flush();
			return toDo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ToDo> toDoList() {
		List<ToDo> toDoList = sessionFactory.getCurrentSession().createQuery("FROM ToDo")
				.list();
       return toDoList;
    }
	
	 public ToDo remove(int id) {
		 Session s = null;
			try {
				s = sessionFactory.getCurrentSession();
				
				ToDo entity = s.get(ToDo.class, id);
				s.delete(entity);
				s.flush();
				return entity;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	    }
}
